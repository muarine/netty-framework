/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.netty.core.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

import java.net.SocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DiscardServerHandler.
 * 
 * @author Muarine maoyun@rtmap.com
 * @date 2015年7月9日
 * @since 2.0
 */
public class DiscardServerHandler implements ChannelHandler {
	
	Logger log = LoggerFactory.getLogger(DiscardServerHandler.class);
	
	
	@Override
	public void bind(ChannelHandlerContext ctx, SocketAddress arg1,
			ChannelPromise arg2) throws Exception {
		// FIXME implement me
	}

	/**
	 * TIME协议(时间协议的服务) 忽略任何接收到的数据,而只是在连接被创建发送一个消息
	 */
	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {

		final ByteBuf time = ctx.alloc().buffer(4); // (2)
		time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

		final ChannelFuture f = ctx.writeAndFlush(time); // (3)
		f.addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture future) {
				assert f == future;
				ctx.close();
			}
		}); // (4)
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// FIXME implement me
	}

	/**
	 * 在数据被接收的时候调用
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {

		ByteBuf in = (ByteBuf) msg;
		try {
			while (in.isReadable()) { // (1)
				System.out.print((char) in.readByte());
				System.out.flush();
			}
		} finally {
			ReferenceCountUtil.release(msg); // (2)
		}

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// FIXME implement me
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void close(ChannelHandlerContext ctx, ChannelPromise arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void connect(ChannelHandlerContext ctx, SocketAddress arg1,
			SocketAddress arg2, ChannelPromise arg3) throws Exception {
		// FIXME implement me
	}

	@Override
	public void deregister(ChannelHandlerContext ctx, ChannelPromise arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void disconnect(ChannelHandlerContext ctx, ChannelPromise arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
		
	}

	@Override
	public void flush(ChannelHandlerContext ctx) throws Exception {
		// FIXME implement me
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// FIXME implement me
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// FIXME implement me
	}

	@Override
	public void read(ChannelHandlerContext ctx) throws Exception {

	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void write(ChannelHandlerContext ctx, Object arg1,
			ChannelPromise arg2) throws Exception {

	}

}
