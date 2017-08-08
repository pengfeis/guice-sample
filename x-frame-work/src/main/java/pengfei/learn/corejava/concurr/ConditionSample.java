package pengfei.learn.corejava.concurr;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSample {

    private Object[] queues = new Object[100];

    private Lock lock = new ReentrantLock();

    private Condition emptyCon = lock.newCondition();
    private Condition fullCon = lock.newCondition();

    int putPrt, takePrt, count;


    private void put(Object obj) {
        try {
            lock.lock();
            System.out.println(this);

            while (count == queues.length) {
                fullCon.await();
            }
            queues[putPrt] = obj;
            emptyCon.signalAll();

            if (++putPrt == queues.length) {
                putPrt = 0;
            }

            ++count;

        } catch (InterruptedException e) {
            System.out.println();
        } finally {
            lock.unlock();
        }
    }

    private Object take() {
        Object result = null;

        try {
            lock.lock();
            System.out.println(this);
            while (count== 0) {
               emptyCon.await();

            }
            result = queues[takePrt];
            if (++takePrt == queues.length) {
                takePrt = 0;
            }
            --count;
            fullCon.signalAll();

        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

        return result;
    }

    @Override
    public String toString() {
        return "ConditionSample{" +
                "queues=" + Arrays.toString(queues) +
                ", lock=" + lock +
                ", emptyCon=" + emptyCon +
                ", fullCon=" + fullCon +
                ", putPrt=" + putPrt +
                ", takePrt=" + takePrt +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {

        final int i = 1;
        final ConditionSample cs = new ConditionSample();
        new Thread(() -> {
            for (;;) {
                cs.put(i + 1);
            }

        }).start();

        new Thread(() -> {
            for (;;) {
                cs.put(i + 1);
            }
        }).start();

        new Thread(() -> {
            for (;;) {
                System.out.println(cs.take());
            }
        }).start();


    }




}
