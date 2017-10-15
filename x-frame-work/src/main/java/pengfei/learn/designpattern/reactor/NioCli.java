package pengfei.learn.designpattern.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class NioCli {

    public static void main(String[] args) {

        while (!Thread.interrupted()) {
            new Thread(new CliTask()).start();
        }

    }

    static class CliTask implements Runnable {

        private Selector initSelector() throws IOException {
            // Create a new selector
            return SelectorProvider.provider().openSelector();
        }

        @Override
        public void run() {
            try {
                SocketChannel cliChannel = SocketChannel.open();
                cliChannel.configureBlocking(false);

                if (!cliChannel.connect(new InetSocketAddress("127.0.0.1", 2345))) {
                    System.out.println("connecting ...");
                    while (!cliChannel.finishConnect()) {
                        System.out.printf(".");
                    }
                }

                long currTime = System.currentTimeMillis();
                StringBuffer sb = new StringBuffer();
                sb.append(Thread.currentThread().getName()).append(String.valueOf(currTime));
                ByteBuffer w = ByteBuffer.wrap(sb.toString().getBytes());
                ByteBuffer read = ByteBuffer.allocate(1024 * 64);
                cliChannel.write(w);


            } catch (Exception e) { }
            finally { }

        }
    }
}
