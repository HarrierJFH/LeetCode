package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Problem98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer val = null;
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        do {
            stack.push(node);
            node = node.left;
        } while (node != null);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (val != null && val >= node.val) {
                return false;
            } else {
                val = node.val;
            }
            if (node.right != null) {
                node = node.right;
                do {
                    stack.push(node);
                    node = node.left;
                } while (node != null);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
