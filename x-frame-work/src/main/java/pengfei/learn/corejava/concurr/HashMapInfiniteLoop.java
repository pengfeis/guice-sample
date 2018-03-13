package pengfei.learn.corejava.concurr;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapInfiniteLoop {

    public static final ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 10l, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(10), new ThreadFactory() {
        private AtomicInteger threadPre = new AtomicInteger(0);

        String poolName = "ONLY-FOR-TEST-PURPOSE";

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, poolName + threadPre.incrementAndGet());
        }
    }, new ThreadPoolExecutor.AbortPolicy());

    private static final HashMap<String, String> map = new HashMap<String, String>(2);

    public static void main(String[] args) throws InterruptedException {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        });


        Thread.currentThread().join();
    }
}
