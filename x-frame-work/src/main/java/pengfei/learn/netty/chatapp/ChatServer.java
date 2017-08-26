package pengfei.learn.netty.chatapp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;

import java.net.InetSocketAddress;

public class ChatServer {
    private final ChannelGroup channelGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    private final EventLoopGroup eventLoopGroup = new NioEventLoopGroup();


    private Channel channel;


    public ChannelFuture start(InetSocketAddress address) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(eventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChatServerInitializer(channelGroup));

        ChannelFuture channelFuture = serverBootstrap.bind(address);

        channelFuture.syncUninterruptibly();
        channel = channelFuture.channel();
        return channelFuture;
    }


    public void destroy() {
        if (channel != null) {
            channel.close();
        }

        channelGroup.close();
        eventLoopGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        ChannelFuture future = server.start(new InetSocketAddress(9999));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.destroy()));
        future.channel().closeFuture().syncUninterruptibly();

    }

}
