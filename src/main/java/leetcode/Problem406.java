package leetcode;

import java.util.Arrays;

public class Problem406 {

    private static class Node {
        int height;
        int k;
        Node next;

        public Node(int height, int k) {
            this.height = height;
            this.k = k;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Node[] groups = new Node[1100];
        int height, k, kMax = 0;
        Node node;
        for (int[] person : people) {
            height = person[0];
            k = person[1];
            kMax = Math.max(k, kMax);
            Node nodeNew = new Node(height, k);
            node = groups[k];
            if (node == null) {
                groups[k] = nodeNew;
            } else {
                if (k == 0) {
                    if (node.height > height) {
                        nodeNew.next = node;
                        groups[k] = nodeNew;
                    } else {
                        while (node.next != null) {
                            if (node.next.height < height) {
                                node = node.next;
                            } else {
                                break;
                            }
                        }
                        nodeNew.next = node.next;
                        node.next = nodeNew;
                    }
                } else {
                    if (node.height < height) {
                        nodeNew.next = node;
                        groups[k] = nodeNew;
                    } else {
                        while (node.next != null) {
                            if (node.next.height > height) {
                                node = node.next;
                            } else {
                                break;
                            }
                        }
                        nodeNew.next = node.next;
                        node.next = nodeNew;
                    }
                }
            }
        }
        Node start = groups[0];
        for (k = 1; k <= kMax; k++) {
            Node in = groups[k], t;
            int c;
            while (in != null) {
                c = 0;
                node = start;
                t = in.next;
                for (;;) {
                    if (node.height >= in.height) {
                        if (++c == in.k) {
                            in.next = node.next;
                            node.next = in;
                            break;
                        }
                    }
                    if (node.next == null) {
                        node.next = in;
                        in.next = null;
                        break;
                    } else {
                        node = node.next;
                    }
                }
                in = t;
            }
        }

        int[][] queue = new int[people.length][2];
        int index = 0;
        node = start;
        while (node != null) {
            queue[index][0] = node.height;
            queue[index++][1] = node.k;
            node = node.next;
        }
        return queue;
    }

    public static void main(String[] args) {
        Problem406 problem = new Problem406();
        System.out.println(Arrays.deepToString(problem.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }

}
