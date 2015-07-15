package com.netty.core.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An HTTP server that sends back the content of the received HTTP request in a
 * pretty plaintext form.
 */
public class HttpServer {
	
	Logger log = LoggerFactory.getLogger(HttpServer.class);
	
	
	private final int port;

	public HttpServer(int port) {
		this.port = port;
	}

	public void run() throws Exception {
		// Configure the server.
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup,workGroup)
							.channel(NioServerSocketChannel.class)
							.childHandler(new DispatcherServletChannelInitializer())
							.option(ChannelOption.SO_BACKLOG, 128)
							.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			// Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync(); // (7)
            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
		}finally{
			workGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
//		AppContext.getInstance().getAppContext();
		int port;
		if(args.length > 0){
			port = Integer.valueOf(args[0]);
		}else{
			port = 8080;
		}
		new HttpServer(port).run();;
	}

}