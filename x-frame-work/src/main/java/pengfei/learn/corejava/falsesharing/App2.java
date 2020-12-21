package pengfei.learn.corejava.falsesharing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class App2 {

    private static final ExecutorService es = Executors.newSingleThreadExecutor();


    private static final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();


    public static void main(String[] args) {

        es.execute(() -> {
            while (true) {
                // do nothing
                String poll = queue.poll();
//                System.out.println(poll);
            }
        });

        es.shutdown();

    }
}
