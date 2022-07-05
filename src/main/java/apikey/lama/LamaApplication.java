package apikey.lama;

import apikey.lama.http2.Http2Util;
import apikey.lama.http2.server.Http2Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class LamaApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(LamaApplication.class, args);
//		server(args);
	}
	private static final int PORT = 8443;
	private static final Logger logger = LoggerFactory.getLogger(Http2Server.class);

	public static void server(String[] args) throws Exception {
		SslContext sslCtx = Http2Util.createSSLContext(true);

		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.option(ChannelOption.SO_BACKLOG, 1024);
			b.group(group)
					.channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							if (sslCtx != null) {
								ch.pipeline()
										.addLast(sslCtx.newHandler(ch.alloc()), Http2Util.getServerAPNHandler());
							}
						}
					});
			Channel ch = b.bind(PORT)
					.sync()
					.channel();
			logger.info("HTTP/2 Server is listening on https://127.0.0.1:" + PORT + '/');

			ch.closeFuture()
					.sync();
		} finally {
			group.shutdownGracefully();
		}
	}
}
