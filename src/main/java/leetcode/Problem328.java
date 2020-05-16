package leetcode;

import leetcode.structure.singlylinkedlist.ListNode;

public class Problem328 {

    public ListNode oddEvenList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode oddTail = head, evenHead = head.next, evenTail = evenHead, cur = evenHead.next;
            head.next = null;
            evenHead.next = null;
            boolean b = true;
            while (cur != null) {
                if (b) {
                    oddTail.next = cur;
                    oddTail = cur;
                } else {
                    evenTail.next = cur;
                    evenTail = cur;
                }
                cur = cur.next;
                b = !b;
            }
            evenTail.next = null;
            oddTail.next = evenHead;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem328 problem = new Problem328();
        ListNode listNode = problem.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        System.out.println(listNode);
    }

}
