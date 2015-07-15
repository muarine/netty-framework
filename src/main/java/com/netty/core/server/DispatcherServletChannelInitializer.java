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
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

import javax.servlet.ServletException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * DispatcherServletChannelInitializer.
 * 
 * @author Muarine maoyun@rtmap.com
 * @date 2015年7月15日
 * @since 2.0
 */
public class DispatcherServletChannelInitializer extends ChannelInitializer<SocketChannel> {
	
	private final DispatcherServlet dispatcherServlet;
	
	public DispatcherServletChannelInitializer() throws ServletException {
		
		MockServletContext servletContext = new MockServletContext();
		MockServletConfig servletConfig = new MockServletConfig(servletContext);
		AnnotationConfigWebApplicationContext wac = new AnnotationConfigWebApplicationContext();
		wac.setServletContext(servletContext);
		wac.setServletConfig(servletConfig);
		wac.register(WebConfig.class);
		wac.setConfigLocation("classpath:applicationContext.xml");
		wac.refresh();
		this.dispatcherServlet = new DispatcherServlet(wac);
		this.dispatcherServlet.init(servletConfig);
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {

		// Create a default pipeline implementation.
		ChannelPipeline pipeline = channel.pipeline();

		// Uncomment the following line if you want HTTPS
		// SSLEngine engine =
		// SecureChatSslContextFactory.getServerContext().createSSLEngine();
		// engine.setUseClientMode(false);
		// pipeline.addLast("ssl", new SslHandler(engine));

		pipeline.addLast("decoder", new HttpRequestDecoder());
		pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
		pipeline.addLast("encoder", new HttpResponseEncoder());
		pipeline.addLast("chunkedWriter", new ChunkedWriteHandler());
		pipeline.addLast("handler", new DiscardServerHandler(this.dispatcherServlet));

	}
	
	@Configuration
	@EnableWebMvc
	@EnableTransactionManagement
	@ComponentScan(basePackages={"com.netty.*.controller"})
	static class WebConfig extends WebMvcConfigurerAdapter {
		
		
		
		
	}

}
