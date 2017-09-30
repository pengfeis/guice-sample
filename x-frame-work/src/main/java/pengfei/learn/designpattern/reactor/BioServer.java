package pengfei.learn.designpattern.reactor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(2345));

            Socket socket = serverSocket.accept();

            // read from client
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            while (!Thread.interrupted()) {
                String line = buf.readLine();
                System.out.println("rec: " + line);
                writer.println(line);
                writer.flush();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
