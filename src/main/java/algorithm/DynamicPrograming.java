package algorithm;

public class DynamicPrograming {
    public int printMaxSum(int[] someInts) {
        int maxSum = 0;
        int currentSum = someInts[0];
        for (int i = 0; i < someInts.length; i++) {
            if (someInts[i] > someInts[i]+ currentSum) {
                currentSum = someInts[i];
            } else {
                currentSum += someInts[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;

    }
}
