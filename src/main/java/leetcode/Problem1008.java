package leetcode;

public class Problem1008 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode last = root;
        TreeNode node;
        TreeNode[] stack = new TreeNode[preorder.length - 1];
        int stackSize = 0;
        for (int i = 1; i < preorder.length; i++) {
            node = new TreeNode(preorder[i]);
            if (node.val < last.val) {
                last.left = node;
                stack[stackSize++] = last;
            } else {
                while (stackSize > 0) {
                    if (stack[stackSize - 1].val > node.val) {
                        break;
                    } else {
                        last = stack[--stackSize];
                    }
                }
                last.right = node;
            }
            last = node;
        }
        return root;
    }

}
