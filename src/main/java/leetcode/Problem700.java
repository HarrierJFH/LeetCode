package leetcode;

import leetcode.structure.TreeNode;

public class Problem700 {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val > val) {
                node = node.left;
            } else if (node.val < val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

}
