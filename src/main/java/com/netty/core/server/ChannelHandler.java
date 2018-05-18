/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.netty.core.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * ChannelHandler.
 * 
 * @author Muarine maoyun@rtmap.com
 * @date 2015年7月16日
 * @since 2.0
 */
public class ChannelHandler extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel e) throws Exception {
		
		ChannelPipeline pipeline = e.pipeline();
		
		pipeline.addLast(new HttpServerCodec());
		
		pipeline.addLast(new ChunkedWriteHandler());
		
		pipeline.addLast(new HttpObjectAggregator(64*1024));
		
//		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
		
//		pipeline.addLast(new WebSocketServerHandler(new DefaultChannelGroup(GlobalEventExecutor.INSTANCE)));

		pipeline.addLast(new DispatcherHandler());
	}
	
	
	
	
	
}
