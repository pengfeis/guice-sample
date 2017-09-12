package algorithm;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoStackAsQueueTest {
    TwoStackAsQueue<Integer> queue = new TwoStackAsQueue<>();

    @Test
    public void putAndPull() throws Exception {
        queue.put(1);
        queue.put(2);
        queue.put(3);

        Assert.assertEquals("1", String.valueOf(queue.poll()));
        Assert.assertEquals("2", String.valueOf(queue.poll()));
        queue.put(4);
        Assert.assertEquals("3", String.valueOf(queue.poll()));
        Object o1 = null;
        Object o2 = null;
        System.out.println(o1 == o2);
    }
}