package leetcode;

public class Problem669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        TreeNode node;
        if (root.val > R) {
            node = root.left;
            while (node != null) {
                if (node.val > R) {
                    node = node.left;
                } else {
                    return trimBST(node, L, R);
                }
            }
            return null;
        } else if (root.val < L) {
            node = root.right;
            while (node != null) {
                if (node.val < L) {
                    node = node.right;
                } else {
                    return trimBST(node, L, R);
                }
            }
            return null;
        }
        node = root;
        while (node.left != null) {
            if (node.left.val >= L) {
                node = node.left;
            } else {
                node.left = trimBST(node.left, L, R);
                break;
            }
        }
        node = root;
        while (node.right != null) {
            if (node.right.val <= R) {
                node = node.right;
            } else {
                node.right = trimBST(node.right, L, R);
                break;
            }
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        @Override
        public String toString() {
            return String.valueOf(val);
        }

        TreeNode(int x) {
            val = x;
        }
    }

}
