package algorithm.leetcode;

public class TwiceIndex {

    public int dominantIndex(int[] nums) {

        int max = nums[0];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            if (num > max) {
                idx = i;
                max = num;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            if (n != max) {
                if (max < n + n) {
                    return -1;
                }
            }
        }

        return idx;
    }

    public static void main(String[] args) {

//        int[] nums = {3, 6, 1, 0};
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {0, 0, 0, 1};
        int idx = new TwiceIndex().dominantIndex(nums);
        System.out.println(idx);

    }
}
