package leetcode;

import leetcode.structure.singlylinkedlist.ListNode;

public class Problem234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean b = false;
        ListNode m = head, h1 = head, h2 = head.next, c = h2.next;
        head.next = null;
        while (c != null) {
            b = !b;
            if (b) {
                m = h2;
                h2 = h2.next;
                m.next = null;
            } else {
                m.next = h1;
                h1 = m;
            }
            c = c.next;
        }
        while(h1 != null) {
            if (h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem234 problem = new Problem234();
        System.out.println(problem.isPalindrome(
                new ListNode(1, new ListNode(2,
                        new ListNode(2, new ListNode(1))))));
    }

}
