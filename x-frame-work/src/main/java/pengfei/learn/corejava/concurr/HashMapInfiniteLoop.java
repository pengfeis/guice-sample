package pengfei.learn.corejava.concurr;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapInfiniteLoop extends Thread{

    private HashMap<Integer, Integer> hashMap = new HashMap<>(2, 0.75f);

    private static AtomicInteger at = new AtomicInteger();

    @Override
    public void run() {
        while (at.get() < 100000) {
            hashMap.put(at.get(), at.get());
            at.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HashMapInfiniteLoop t1 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t2 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t3 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t4 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t5 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t6 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t7 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t8 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t9 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t10 = new HashMapInfiniteLoop();
        HashMapInfiniteLoop t11= new HashMapInfiniteLoop();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();

        System.out.println("all-start");
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
        t10.join();
        t11.join();

    }
}
