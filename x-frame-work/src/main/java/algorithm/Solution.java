package algorithm;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    List<Integer> ret = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root != null) {
            ret.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode three = new TreeNode(3, null, null);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode root = new TreeNode(1, null, two);

        List<Integer> items = solution.preorderTraversal(root);

        System.out.println(items);
    }


    @Getter
    @Setter
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
