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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatServer {

    private final ChannelGroup channelGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    private final EventLoopGroup bossGroup = new NioEventLoopGroup(3, new ThreadFactory() {
        private AtomicInteger idx = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "CHAT_BOSS_THREAD_" + idx.getAndIncrement());
        }
    });
    private final EventLoopGroup workerGroup = new NioEventLoopGroup(2, new ThreadFactory() {
        private AtomicInteger idx = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "CHAT_CHILD_THREAD_" + idx.getAndIncrement());
        }
    });

    private Channel channel;


    public ChannelFuture start(InetSocketAddress address) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
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
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        ChannelFuture future = server.start(new InetSocketAddress(9999));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.destroy()));
        future.channel().closeFuture().syncUninterruptibly();

    }

}
