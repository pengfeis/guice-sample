package pengfei.learn.designpattern.reactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

public class SocketClient {
    public static void main(String[] args) throws InterruptedException {
        while (!Thread.interrupted()) {
            Thread.sleep(1000l);
            new Thread(new ClientTask()).start();
        }

        Thread.currentThread().join();

    }

    static class ClientTask implements Runnable{

        // TODO where is connect
        @Override
        public void run() {
            try {
                long l = System.currentTimeMillis();
                Socket socket = new Socket("127.0.0.1", 2345);
//                socket.setSoTimeout(100);

                // socket output steam for send data to server
                PrintStream out = new PrintStream(socket.getOutputStream());
                // sent to server

                out.println(Thread.currentThread().getName() + "-" + l);

                // socket input stream for recieve data from server
                BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                System.out.println(buf.readLine());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
