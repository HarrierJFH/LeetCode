package leetcode;

public class Problem451 {

//    public String frequencySort0(String s) {
//        if (s.length() < 3) {
//            return s;
//        }
//        int[] a = new int[128];
//        Node[] nodes = new Node[128];
//        Node[] cache = new Node[128];
//        int i = 0, count;
//        char c = s.charAt(i);
//        ++a[c];
//        Node node = new Node(c);
//        nodes[c] = node;
//        Node first = node, last = node, t;
//        for (i = 1; i < s.length(); i++) {
//            c = s.charAt(i);
//            count = ++a[c];
//            node = nodes[c];
//            if (node == null) {
//                node = new Node(c);
//                nodes[c] = node;
//                t = cache[1];
//                if (t == null) {
//                    last.next = node;
//                    node.previous = last;
//                    last = node;
//                } else {
//                    node.next = t;
//                    node.previous = t.previous;
//                    t.previous.next = node;
//                    t.previous = node;
//                }
//                cache[1] = node;
//            } else {
//                if (node.previous == null) {
//                    cache[count] = node;
//                    cache[count - 1] = node.next;
//                    continue;
//                }
//                t = cache[count];
//                if (t == node) {
//                    continue;
//                }
//                if (t != null && t == node.next) {
//                    cache[count] = node;
//                    continue;
//                }
//                if (last == node) {
//                    last = node.previous;
//                }
//                node.previous.next = node.next;
//                if (node.next != null) {
//                    node.next.previous = node.previous;
//                }
//                if (t == first || t == null && a[node.val] > a[first.val]) {
//                    node.next = first;
//                    node.previous = null;
//                    first.previous = node;
//                    first = node;
//                } else if (t == null) {
//                    last.next = node;
//                    node.previous = last;
//                    last = node;
//                } else {
//                    node.previous = t.previous;
//                    node.next = t;
//                    t.previous.next = node;
//                    t.previous = node;
//                }
//                if (cache[count - 1] == node) {
//                    t = node;
//                    do {
//                        t = t.next;
//                        if (t == null) {
//                            break;
//                        }
//                    } while (a[t.val] > count - 1);
//                    cache[count - 1] = t;
//                }
//                cache[count] = node;
//            }
//        }
//        node = first;
//        StringBuilder stringBuilder = new StringBuilder(s.length());
//        do {
//            count = a[node.val];
//            for (i = 0; i < count; i++) {
//                stringBuilder.append(node.val);
//            }
//            node = node.next;
//        } while (node != null);
//        return stringBuilder.toString();
//    }

    public String frequencySort(String s) {
        if (s.length() < 3) {
            return s;
        }
        int[] a = new int[128];
        Node[] nodes = new Node[128];
        int i = 0, count;
        char c = s.charAt(i);
        ++a[c];
        Node node = new Node(c);
        nodes[c] = node;
        Node first = node, last = node, t;
        for (i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            count = ++a[c];
            node = nodes[c];
            if (node == null) {
                node = new Node(c);
                nodes[c] = node;
                node.previous = last;
                last.next = node;
                last = node;
            } else if (node.previous != null) {
                t = node.previous;
                if (a[t.val] < count) {
                    if (last == node) {
                        last = node.previous;
                    }
                    t = t.previous;
                }
                while (t != null) {
                    if (a[t.val] < count) {
                        t = t.previous;
                    } else {
                        break;
                    }
                }
                if (t == node.previous) {
                    continue;
                }
                node.previous.next = node.next;
                if (node.next != null) {
                    node.next.previous = node.previous;
                }
                if (t == null) {
                    first.previous = node;
                    node.previous = null;
                    node.next = first;
                    first = node;
                } else {
                    t.next.previous = node;
                    node.previous = t;
                    node.next = t.next;
                    t.next = node;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder(s.length());
        node = first;
        do {
            count = a[node.val];
            for (i = 0; i < count; i++) {
                stringBuilder.append(node.val);
            }
            node = node.next;
        } while (node != null);
        return stringBuilder.toString();
    }

    private static class Node {
        public char val;
        public Node previous;
        public Node next;

        public Node(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Problem451 problem = new Problem451();
        System.out.println(problem.frequencySort("abcc"));
        System.out.println(problem.frequencySort("ABBCCCDDDDEEEEE"));
        System.out.println(problem.frequencySort("abaccadeeefaafcc"));
        System.out.println(problem.frequencySort("abbbaacacf"));
    }

}
