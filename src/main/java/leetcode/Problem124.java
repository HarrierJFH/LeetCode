package leetcode;

public class Problem124 {

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

    public int maxPathSum(TreeNode root) {
        int max = Integer.MIN_VALUE, sum = 0, l = 0;
        if (root.left != null) {
            max = Math.max(max, maxPathSum(root.left));
            if (root.left.val > 0) {
                sum += root.left.val;
                l = sum;
            }
        }
        if (root.right != null) {
            max = Math.max(max, maxPathSum(root.right));
            if (root.right.val > 0) {
                sum += root.right.val;
                l = Math.max(l, root.right.val);
            }
        }
        max = Math.max(max, sum + root.val);
        root.val += l;
        return max;
    }

}
