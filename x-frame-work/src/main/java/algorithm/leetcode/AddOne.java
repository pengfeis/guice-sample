package algorithm.leetcode;

public class AddOne {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length -1; i >= 0; i--) {
            int n = digits[i];

            int tmp = n + 1;
            if (tmp < 10) {
                digits[i] = tmp;
                return digits;
            } else {
                // 处理进位
                if (i == 0) {

                    int[] result = new int[digits.length + 1];
                    for (int k = 0; k < result.length; k++) {
                        result[k] = 0;
                    }
                    result[0]=1;
                    return result;

                }
                digits[i] = 0;

                int preIdx = i - 1;
                int pre = digits[preIdx];
                if (pre + 1 < 10) {
                    digits[preIdx] = pre + 1;
                    return digits;
                }

            }

        }

        return digits;
    }


    public static void main(String[] args) {
        int[] nums = {9, 9, 8, 9};
        int[] result = new AddOne().plusOne(nums);

        for (int i = 0; i < result.length; i++) {
            int i1 = result[i];
            System.out.println(i1);
        }

    }
}
