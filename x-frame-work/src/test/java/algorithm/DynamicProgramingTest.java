package algorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicProgramingTest {

    @Test
    public void testFindMaxSumArraySum() {
        int someInts[] = {1, -2, 3, 10, -4, 7, 2, -5};

        int max = new DynamicPrograming().printMaxSum(someInts);

        assertEquals(18, max);

    }

}