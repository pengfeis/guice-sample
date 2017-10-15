package pengfei.learn.designpattern.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

public class NioCli {

    public static void main(String[] args) throws InterruptedException {

        while (!Thread.interrupted()) {
            Thread.sleep(1000l);
            new Thread(new CliTask()).start();
        }

        Thread.currentThread().join();
    }

    static class CliTask implements Runnable {

        private Selector selector;

        private Selector initSelector() throws IOException {
            // Create a new selector
            return SelectorProvider.provider().openSelector();
        }


        public void initCli(String ip, int port) throws IOException {

            // get socket channel
            SocketChannel cliChannel = SocketChannel.open();
            // 设置channel为非阻塞模式
            cliChannel.configureBlocking(false);
            // 获取selector
            this.selector = Selector.open();

            // 客户端连接服务器,其实方法执行并没有实现连接，需要在调用channel.finishConnect()才能完成连接
            cliChannel.connect(new InetSocketAddress(ip, port));
            //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
            cliChannel.register(selector, SelectionKey.OP_CONNECT);


        }

        @Override
        public void run() {
            try {
                while (Thread.interrupted()) {
                    selector.select();
                    // get the connected keys

                    Iterator ite = this.selector.selectedKeys().iterator();
                    while (ite.hasNext()) {
                        SelectionKey key = (SelectionKey) ite.next();
                        // del selected key, else it will be selected next select call\
                        ite.remove();
                        if (key.isAcceptable()) {
                            SocketChannel channel = (SocketChannel) key.channel();

                            if (channel.isConnectionPending()) {
                                while (!channel.finishConnect()) {
                                    System.out.print(".");
                                }
                            }

                            channel.configureBlocking(false);
                            //在这里可以给服务端发送信息
                            String content = Thread.currentThread().getName() + "-" + System.currentTimeMillis();
                            channel.write(ByteBuffer.wrap(new String(content).getBytes()));
                            //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                            channel.register(this.selector, SelectionKey.OP_READ);
                        } else if (key.isReadable()) {
                            // read
                        }
                    }
                }

            } catch (Exception e) {
            } finally {
            }

        }
    }
}
