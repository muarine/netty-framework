/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.netty.core.server;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Global.
 * 
 * @author Muarine maoyun@rtmap.com
 * @date 2015年7月16日
 * @since 2.0
 */
public class Global {

	public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
}
