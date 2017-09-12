package pengfei.learn.corejava.concurr.inpractice;

import java.time.Instant;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SingletonThreadPool {


    enum Pool {
        INSTANCE;

        private volatile ExecutorService service;

        Pool() {
            service = new ThreadPoolExecutor(5, 10, 0l, TimeUnit.MILLISECONDS,
                    new LinkedBlockingDeque<>(10), new ThreadFactory() {

                final AtomicInteger counter = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "customer thread name of " + counter.incrementAndGet());
                }
            }, new ThreadPoolExecutor.AbortPolicy());
        }

        public void exec(Runnable runnable) {
            service.execute(runnable);
        }
    }




    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i< 20; i++) {
            Pool.INSTANCE.exec(() -> {
                System.out.println(Pool.INSTANCE == Pool.INSTANCE);
                System.out.println(Thread.currentThread().getName());
                System.out.println(Instant.now());
            });
        }

        Thread.currentThread().join();


    }
}
