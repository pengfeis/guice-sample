package algorithm.leetcode;

public class DiagonalTrial {

    public int[] findDiagonalOrder(int[][] matrix) {

        int high = matrix.length;
        int width = matrix[0].length;
        int[] result = new int[high * width];

        int idx = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; row != null && j < row.length; ++j) {
                int n = row[j];
                result[idx] = n;
                idx++;
            }
        }


        for (int i = 0; i < result.length; i++) {
            
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] nums = new DiagonalTrial().findDiagonalOrder(a);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
