package leetcode;

public class Problem543 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }


    public int diameterOfBinaryTree(TreeNode root) {
        return root != null ? diameter(root) : 0;
    }

    private int diameter(TreeNode node) {
        int diameter = 0;
        int l = 0;
        int r = 0;
        node.val = 0;
        if (node.left != null) {
            diameter = Math.max(diameter, diameter(node.left));
            l = node.left.val + 1;
            node.val = Math.max(node.val, l);
        }
        if (node.right != null) {
            diameter = Math.max(diameter, diameter(node.right));
            r = node.right.val + 1;
            node.val = Math.max(node.val, r);
        }
        return Math.max(diameter, l + r);
    }

}
