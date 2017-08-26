package pengfei.learn.corejava.concurr;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ParkWillStopThread {

    private static Object obj = new Object();


    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("begin point");
//                LockSupport.park(obj);
//            }
//        }).start();


        ParkWillStopThread p = new ParkWillStopThread();
        System.out.println("COUNT_BITS" + COUNT_BITS);
        System.out.println("CAPACITY" + CAPACITY);
        System.out.println("RUNNING" + RUNNING);
        System.out.println("SHUTDOWN" + SHUTDOWN);
        System.out.println("STOP" + STOP);
        System.out.println("TIDYING" + TIDYING);
        System.out.println("TERMINATED" + TERMINATED);


        System.out.println(-536870912 & 536870911);
        System.out.println(~CAPACITY);

        System.out.println(RUNNING | 0);

    }
}
