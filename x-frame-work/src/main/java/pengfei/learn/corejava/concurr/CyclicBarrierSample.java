package pengfei.learn.corejava.concurr;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println(1));

        new Thread(() -> {
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        }).start();

        new Thread(()-> {
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        }).start();


        cb.await();


        System.out.println(4);

    }
}
