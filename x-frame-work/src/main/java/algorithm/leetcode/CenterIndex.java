package algorithm.leetcode;

public class CenterIndex {

    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int l = sumLeft(i, nums);
            int r = sumRight(i, nums);
            if (l == r) {
                return i;
            }

        }
        return -1;
    }

    private int sumLeft(int idx, int[] nums) {
        int sum = 0;
        for (int i = 0; i < idx; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int sumRight(int idx, int[] nums) {
        int sum = 0;
        for (int i = idx + 1; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {-1,-1,-1,0,1,1};

        int ctrIdx = new CenterIndex().pivotIndex(nums);

        System.out.println(ctrIdx);
    }


}
