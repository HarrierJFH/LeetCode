package leetcode;

import leetcode.structure.TreeNode;

import java.util.*;

public class Problem107 {

    @SuppressWarnings("unchecked")
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Deque<TreeNode> l1 = new ArrayDeque<>(), l2 = new ArrayDeque<>(), t;
        TreeNode node;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        l1.add(root);
        for (; ; ) {
            node = l1.pop();
            level.add(node.val);
            if (node.left != null) {
                l2.add(node.left);
            }
            if (node.right != null) {
                l2.add(node.right);
            }
            if (l1.isEmpty()) {
                t = l1;
                l1 = l2;
                l2 = t;
                result.add(0, level);
                level = new LinkedList<>();
                if (l1.isEmpty()) {
                    break;
                }
            }
        }
        return result;
    }

}
