package pengfei.learn.designpattern.reactor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BioServer implements Runnable {

    private Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        try {
            new Thread(new BioServer()).start();
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket();

            serverSocket.bind(new InetSocketAddress(2345));

            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                this.executor.execute(new Handler(socket));
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }
    }


    static class Handler implements Runnable {

        final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try {
                // read from client
                BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                String line = buf.readLine();
                System.out.println("rec: " + line);
                writer.println(line);
                writer.flush();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}

