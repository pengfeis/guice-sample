package pengfei.learn.designpattern.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * copy doug lea's idea
 */
public class Reactor implements Runnable {

    private Selector selector;

    final ServerSocketChannel ssc;


    Reactor(int port) throws IOException {
        selector = Selector.open(); // create selector, its depends os.
        ssc = ServerSocketChannel.open();   // create Server-Socket Channel, thread-safe
        ssc.socket().bind(new InetSocketAddress(port)); // bind specific port

        ssc.configureBlocking(false);

        // server channel 注册接受连接
        SelectionKey sk = ssc.register(selector, SelectionKey.OP_ACCEPT);

        // 把一个Acceptor贴到这个key上，此key是当server socket channel接受连接请求完成后返回的。
        sk.attach(new Acceptor());
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                int selectedCount = selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    // 此key包含一个客户端连接
                    dispatch(it.next());
                }
                keys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void dispatch(SelectionKey k) {
        Runnable r = (Runnable) (k.attachment());
        if (r != null) {
            r.run();
        }
    }


    /**
     * 在这里的Acceptor只有一个，serverSoChannel会在accept方法返回一个soChannel
     */
    class Acceptor implements Runnable {
        public void run() {
            try {
                // ssc is non-blocking, so this method return immediately.
                SocketChannel c = ssc.accept();
                if (c != null)
                    new Handler(selector, c); //
            } catch (IOException ex) { /* ... */ }
        }
    }


    final class Handler implements Runnable {
        final SocketChannel soChannel;
        final SelectionKey sk;

        private ByteBuffer input = ByteBuffer.allocate(1024 * 64);
        private ByteBuffer output = ByteBuffer.allocate(1024 * 64);

        boolean inputIsDone() { return true; }
        boolean outputIsDone() { return true; }

        static final int READING = 0;
        static final int SENDING = 1;
        int state = READING;

        Handler(Selector selector, SocketChannel channel) throws IOException {
            this.soChannel = channel;
            channel.configureBlocking(false);
            sk = soChannel.register(selector, 0);
            sk.attach(this);
            sk.interestOps(SelectionKey.OP_READ);
            selector.wakeup();
        }

        @Override
        public void run() {

//            try {
//                if (state == READING) {
//                    read();
//                } else if (state == SENDING) {
//                    send();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }


            try {
                soChannel.read(input);
                if (inputIsDone()) {
//                    process();
                    Thread.sleep(100);
                    sk.attach(new Sender());
                    sk.interestOps(SelectionKey.OP_WRITE);
                    sk.selector().wakeup();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        void read() throws IOException, InterruptedException {
            soChannel.read(input);
            if (inputIsDone()) {
                // do buz logic, now let mock
                Thread.sleep(100l);
                state = SENDING;
                sk.interestOps(SelectionKey.OP_WRITE);
            }
        }

        void send() throws IOException {
            soChannel.write(output);
            if (outputIsDone()) sk.cancel();
        }


        // state-object pattern
        class Sender implements Runnable {

            @Override
            public void run() {
                try {
                    soChannel.write(output);
                    if (outputIsDone()) {
                        sk.cancel();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    // main of Reactor
    public static void main(String[] args) {
        try {
            new Thread(new Reactor(2345), "Reactor-Thread-001").start();

            Thread.currentThread().join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
