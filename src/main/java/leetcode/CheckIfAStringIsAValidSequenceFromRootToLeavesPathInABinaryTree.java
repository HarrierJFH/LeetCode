package leetcode;

public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }

    private boolean isValidSequence(TreeNode root, int[] arr, int from) {
        if (root == null) {
            return false;
        }
        if (arr.length == from + 1) {
            return root.val == arr[from] && root.left == null && root.right == null;
        }
        if (root.val == arr[from]) {
            return isValidSequence(root.left, arr, from + 1) || isValidSequence(root.right, arr, from + 1);
        }
        return false;
    }

}
