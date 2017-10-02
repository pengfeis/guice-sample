package pengfei.learn.designpattern.reactor;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NioServer {

    private Selector selector;

    public void init() {
        try {
            this.selector = Selector.open();

            ServerSocketChannel serverChannel = ServerSocketChannel.open();

            serverChannel.configureBlocking(false);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
