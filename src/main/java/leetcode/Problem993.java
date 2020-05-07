package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem993 {

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

    public boolean isCousins(TreeNode root, int x, int y) {
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> depths = new ArrayList<>();
        if (root == null) {
            return false;
        }
        if (root.val == x || root.val == y) {
            return false;
        }
        nodes.add(root);
        depths.add(0);
        TreeNode node;
        int depth, maxDepth = Integer.MAX_VALUE;
        boolean xFound = false, yFound = false;
        for (int i = 0; i < nodes.size(); i++) {
            node = nodes.get(i);
            depth = depths.get(i);
            if (depth > maxDepth) {
                return false;
            }
            if (node.left != null) {
                if (node.left.val == x) {
                    if (yFound) {
                        return true;
                    } else if (node.right != null && node.right.val == y) {
                        return false;
                    } else {
                        xFound = true;
                        maxDepth = depth;
                    }
                } else if (node.left.val == y) {
                    if (xFound) {
                        return true;
                    } else if (node.right != null && node.right.val == x) {
                        return false;
                    } else {
                        yFound = true;
                        maxDepth = depth;
                    }
                } else if (depth < maxDepth) {
                    nodes.add(node.left);
                    depths.add(depth + 1);
                }
            }
            if (node.right != null) {
                if (node.right.val == x) {
                    if (yFound) {
                        return true;
                    } else {
                        xFound = true;
                        maxDepth = depth;
                    }
                } else if (node.right.val == y) {
                    if (xFound) {
                        return true;
                    } else {
                        yFound = true;
                        maxDepth = depth;
                    }
                } else if (depth < maxDepth) {
                    nodes.add(node.right);
                    depths.add(depth + 1);
                }
            }
        }
        return false;
    }

}
