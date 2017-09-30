package pengfei.learn.designpattern.reactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 2345);
            socket.setSoTimeout(2000);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            // socket output steam for send data to server
            PrintStream out = new PrintStream(socket.getOutputStream());


            // socket input stream for recieve data from server
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            boolean f = true;
            while (f) {
                System.out.println("input: ");
                String str = br.readLine();

                // sent to server
                out.println(str);
                if ("bye".equals(str)) {
                    f = false;
                } else {
                    String echo = buf.readLine();
                    System.out.println(echo);
                }
            }

            br.close();

            if (socket != null) {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
