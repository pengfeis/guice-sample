package pengfei.learn.designpattern.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * copy doug lea
 */
public class AnReactor implements Runnable {
    private Selector selector;
    final ServerSocketChannel serverSocketChannel;


    AnReactor(int port) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    dispatch(it.next());
                    keys.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    void dispatch(SelectionKey k) {
        Runnable r = (Runnable) (k.attachment());
        if (r != null)
            r.run();
    }


    class Acceptor implements Runnable { // inner
        public void run() {
            try {
                SocketChannel c = serverSocketChannel.accept();
//                if (c != null)
                //  new Handler(selector, c);
            } catch (IOException ex) { /* ... */ }
        }
    }
}
