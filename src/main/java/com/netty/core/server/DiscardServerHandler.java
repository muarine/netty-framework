/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.netty.core.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

import java.net.SocketAddress;

/**
 * DiscardServerHandler.
 * 
 * @author Muarine maoyun@rtmap.com
 * @date 2015年7月9日
 * @since 2.0
 */
public class DiscardServerHandler implements ChannelHandler {

	@Override
	public void bind(ChannelHandlerContext arg0, SocketAddress arg1,
			ChannelPromise arg2) throws Exception {
		// FIXME implement me
	}

	@Override
	public void channelActive(ChannelHandlerContext arg0) throws Exception {
		// FIXME implement me
	}

	@Override
	public void channelInactive(ChannelHandlerContext arg0) throws Exception {
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
	public void channelReadComplete(ChannelHandlerContext arg0)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void channelRegistered(ChannelHandlerContext arg0) throws Exception {
		// FIXME implement me
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext arg0)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext arg0)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void close(ChannelHandlerContext arg0, ChannelPromise arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void connect(ChannelHandlerContext arg0, SocketAddress arg1,
			SocketAddress arg2, ChannelPromise arg3) throws Exception {
		// FIXME implement me
	}

	@Override
	public void deregister(ChannelHandlerContext arg0, ChannelPromise arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void disconnect(ChannelHandlerContext arg0, ChannelPromise arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext arg0, Throwable arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void flush(ChannelHandlerContext arg0) throws Exception {
		// FIXME implement me
	}

	@Override
	public void handlerAdded(ChannelHandlerContext arg0) throws Exception {
		// FIXME implement me
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext arg0) throws Exception {
		// FIXME implement me
	}

	@Override
	public void read(ChannelHandlerContext arg0) throws Exception {
		
		
		
		
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext arg0, Object arg1)
			throws Exception {
		// FIXME implement me
	}

	@Override
	public void write(ChannelHandlerContext arg0, Object arg1,
			ChannelPromise arg2) throws Exception {
		
		
	}

}
