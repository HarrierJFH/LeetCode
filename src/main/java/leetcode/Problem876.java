package leetcode;

public class Problem876 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode middle = head;
        boolean b = true;
        while (head.next != null) {
            if (b) {
                middle = middle.next;
                b = false;
            } else {
                b = true;
            }
            head = head.next;
        }
        return middle;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}