package leetcode;

public class Problem19 {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        if (n == 1) {
            ListNode last = null;
            while (node.next != null) {
                last = node;
                node = node.next;
            }
            if (last != null) {
                last.next = null;
                return head;
            } else {
                return null;
            }
        } else {
            ListNode[] nodes = new ListNode[n];
            int i=0;
            for (; ; ) {
                if (node.next != null) {
                    nodes[i++] = node;
                    if (i == n) {
                        i = 0;
                    }
                    node = node.next;
                } else {
                    if (nodes[i] == null) {
                        return head.next;
                    } else {
                        nodes[i].next = nodes[i].next.next;
                        return head;
                    }
                }
            }
        }
    }

}
