package pengfei.learn.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author pengfeisu
 */
public class NettyServer {

    /**
     * 用于接受accept事件的group serverSocketChannel
     */
    EventLoopGroup bossGroup = new NioEventLoopGroup(2);
    /**
     * 用于真正读写事件的group socketChannel
     */
    EventLoopGroup workerGroup = new NioEventLoopGroup(4);

    public void start() {
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.channel(NioServerSocketChannel.class)
                    .group(bossGroup, workerGroup)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(new IdleStateHandler(5, 0, 0));
                        }
                    });

            ChannelFuture channelFuture = b.bind(9999).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {

    }
}
