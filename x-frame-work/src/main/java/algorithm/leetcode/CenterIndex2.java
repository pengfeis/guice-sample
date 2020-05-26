package algorithm.leetcode;

public class CenterIndex2 {

    public int pivotIndex(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            int r = sumRight(i, nums);
            if (r == left) {
                return i;
            }
        }
        return -1;
    }

    private int sumRight(int idx, int[] nums) {
        int sum = 0;
        for (int i = idx; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,0,1,1};

        int idx = new CenterIndex2().pivotIndex(nums);
        System.out.println(idx);
    }
}
