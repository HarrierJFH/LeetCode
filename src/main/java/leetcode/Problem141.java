package leetcode;

import java.util.List;

public class Problem141 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        ListNode node = head;
        ListNode last = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            if (last != null) {
                node.next = last;
            }
            last = node;
            node = next;
            if (node == head) {
                return true;
            }
        }
        return false;
    }

}
