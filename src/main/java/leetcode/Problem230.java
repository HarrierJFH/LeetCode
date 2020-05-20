package leetcode;

import leetcode.structure.TreeNode;

public class Problem230 {

    public int kthSmallest(TreeNode root, int k) {
        int val = 0, f = 0;
        if (root.left != null) {
            val = kthSmallest(root.left, k);
            f = root.left.val;
        }
        if (f >= k) {
            root.val = f;
        } else if (++f == k) {
            val = root.val;
            root.val = f;
        } else {
            if (root.right != null) {
                val = kthSmallest(root.right, k - f);
                f += root.right.val;
            }
            root.val = f;
        }
        return val;
    }

}
