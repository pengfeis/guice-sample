package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 */
public class TripleSum {


    public static void main(String[] args) {


        TripleSum sum = new TripleSum();
       int[] nums =  {-1, 0, 1, 2, -1, -4};


        List<List<Integer>> lists = sum.new Solution().threeSum(nums);
        System.out.println(lists);

    }


    class Solution {


        /**
         * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
         * <p>
         * 满足要求的三元组集合为：
         * [
         * [-1, 0, 1],
         * [-1, -1, 2]
         * ]
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int b = nums[j];
                    for (int k = j; k < nums.length; k++) {
                        int c = nums[k];
                        if (a + b + c == 0) {
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(a);
                            tmp.add(b);
                            tmp.add(c);
                            result.add(tmp);
                        }
                    }

                }

            }

            return result;
        }


    }
}
