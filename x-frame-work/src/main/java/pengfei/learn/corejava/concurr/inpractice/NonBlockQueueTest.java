package pengfei.learn.corejava.concurr.inpractice;

import java.util.concurrent.ConcurrentLinkedQueue;

public class NonBlockQueueTest {
    public static void main(String[] args) throws InterruptedException {




        ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<>();
        for (int i=0; i< 1000; i++) {
            clq.offer(i);
        }



        System.out.println("test" + clq);
    }
}
