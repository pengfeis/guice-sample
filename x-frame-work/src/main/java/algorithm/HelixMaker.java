//package algorithm;
//
//public class HelixMaker {
//
//
//    /**
//     * 1  2  3  4  5  6
//     * 14 15 16 17 18 7
//     * 13 12 11 10 9  8
//     */
//    public static int[][] make(int row, int col, boolean isDesc) {
//
//        if (row <= 1 || col <= 1) {
//            throw new IllegalArgumentException("positive value");
//        }
//
//        int[] con = new int[row * col];
//
//        for (int i = 0; i <= con.length; i++) {
//            if (isDesc) {
//                con[i] = con.length - i;
//            } else {
//                con[i] = i + 1;
//            }
//        }
//
//
//        int[][] result = new int[row][col];
//
//
//        int curr = 0;
//
//        for (int i = 0; i < row; i++) {
//            for (int k = 0; k < col; k++) {
//                if ()
//                    result[i][k] =
//            }
//        }
//
//        return result;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(make(3, 5));
//    }
//
//}