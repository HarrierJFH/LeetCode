package leetcode;

import leetcode.structure.TreeNode;

public class Problem108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int offset, int length) {
        if (length == 0) {
            return null;
        }
        int m = length / 2;
        TreeNode root = new TreeNode(nums[m + offset]);
        if (length >= 1) {
            root.left = sortedArrayToBST(nums, offset, m);
            root.right = sortedArrayToBST(nums, m + offset + 1, length % 2 == 1 ? m : m - 1);
        }
        return root;
    }

}
