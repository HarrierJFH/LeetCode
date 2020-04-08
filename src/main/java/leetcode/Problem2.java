package leetcode;

public class Problem2 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1.val = l1.val + l2.val;
        if (l1.next != null) {
            if (l2.next != null) {
                if (l1.val >= 10) {
                    l1.val -= 10;
                    l1.next.val += 1;
                }
                l1.next = addTwoNumbers(l1.next, l2.next);
            } else {
                if (l1.val >= 10) {
                    l1.val -= 10;
                    l1.next = addTwoNumbers(l1.next, new ListNode(1));
                }
            }
        } else {
            if (l2.next != null) {
                if (l1.val >= 10) {
                    l1.val -= 10;
                    l1.next = addTwoNumbers(l2.next, new ListNode(1));
                } else {
                    l1.next = l2.next;
                }
            } else {
                if (l1.val >= 10) {
                    l1.val -= 10;
                    l1.next = new ListNode(1);
                }
            }
        }
        return l1;
    }
}
