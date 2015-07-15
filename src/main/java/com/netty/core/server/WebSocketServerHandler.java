/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.netty.core.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * WebSocketServerHandler.
 * 
 * @author Muarine maoyun@rtmap.com
 * @date 2015年7月16日
 * @since 2.0
 */
@Sharable
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object>{

	private static final Logger logger = LoggerFactory.getLogger(WebSocketServerHandler.class);
	
	private WebSocketServerHandshaker handshaker;
	
	private ChannelGroup recipients;
	
	/**
	 * Create a new WebSocketServerHandler.
	 * 
	 */
	public WebSocketServerHandler(ChannelGroup recipients) {
		this.recipients = recipients;
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		recipients.add(ctx.channel());  
        System.out.println("connect:"+recipients.size()); 
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		try {  
            recipients.remove(ctx.channel());  
            System.out.println("删除channel成功"+recipients.size());  
        } catch (Exception ex) {  
            System.out.println("删除channel失败"+ex.getMessage());  
        } 
	}

	/**
	 * 消息接收
	 */
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		if (msg instanceof FullHttpRequest) {
			handleHttpRequest(ctx, (FullHttpRequest) msg);
		} else if (msg instanceof TextWebSocketFrame) {
			handlerWebSocketFrame(ctx, (WebSocketFrame) msg);
//			TextWebSocketFrame frame = (TextWebSocketFrame)msg;
//			String request = frame.text();  
//	        //ctx.channel().writeAndFlush(new TextWebSocketFrame(request.toUpperCase()));  
//	        System.out.println("size:"+recipients.size());  
//	        System.out.println("content:" + frame.text());
//	        recipients.write(new TextWebSocketFrame(request.toUpperCase()));  
		}
	}
	
	@Override
	public void close(ChannelHandlerContext ctx, ChannelPromise promise)
			throws Exception {
		ctx.close();
		System.out.println("close");
	}

	/**
	 * WebSocket
	 * 
	 * @param ctx
	 * @param frame
	 */
	private void handlerWebSocketFrame(ChannelHandlerContext ctx,
			WebSocketFrame frame) {
		// 判断是否关闭链路的指令
		if (frame instanceof CloseWebSocketFrame) {
			handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame
					.retain());
		}
		// 判断是否ping消息
		if (frame instanceof PingWebSocketFrame) {
			ctx.channel().write(
					new PongWebSocketFrame(frame.content().retain()));
			return;
		}
		// 本例程仅支持文本消息，不支持二进制消息
		if (!(frame instanceof TextWebSocketFrame)) {
			System.out.println("本例程仅支持文本消息，不支持二进制消息");
			throw new UnsupportedOperationException(String.format(
					"%s frame types not supported", frame.getClass().getName()));
		}
		// 返回应答消息
		String request = ((TextWebSocketFrame) frame).text();
		System.out.println("服务端收到：" + request);
		logger.info(String.format("%s %s received %s", ctx.channel() , ctx.channel().id() , request));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TextWebSocketFrame tws = new TextWebSocketFrame(sdf.format(new Date()) + ctx.channel().id() + "：" + request);
		// 群发
//		this.recipients.writeAndFlush(tws);
		ctx.writeAndFlush(tws);
		// 返回【谁发的发给谁】
		// ctx.channel().writeAndFlush(tws);
	}
	
	/**
	 * Http请求
	 * 
	 * @param ctx
	 * @param req
	 */
	private void handleHttpRequest(ChannelHandlerContext ctx,
			FullHttpRequest req) {
		if (!req.decoderResult().isSuccess()
				|| (!"websocket".equals(req.headers().get("Upgrade")))) {
			sendHttpResponse(ctx, req, new DefaultFullHttpResponse(
					HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
			return;
		}
		WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
				"ws://" + req.headers().get(HttpHeaders.HOST) , null, false);
		handshaker = wsFactory.newHandshaker(req);
		if (handshaker == null) {
			WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
		} else {
			handshaker.handshake(ctx.channel(), req);
			recipients.add(ctx.channel());
		}
	}
	
	
	private static void sendHttpResponse(ChannelHandlerContext ctx,
			FullHttpRequest req, DefaultFullHttpResponse res) {
		// 返回应答给客户端
		if (res.status().code() != 200) {
			ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(),
					CharsetUtil.UTF_8);
			res.content().writeBytes(buf);
			buf.release();
		}
		// 如果是非Keep-Alive，关闭连接
		ChannelFuture f = ctx.channel().writeAndFlush(res);
		if (!isKeepAlive(req) || res.status().code() != 200) {
			f.addListener(ChannelFutureListener.CLOSE);
		}
	}
	private static boolean isKeepAlive(FullHttpRequest req) {
		return false;
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
	
}
