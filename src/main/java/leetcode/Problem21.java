package leetcode;

import leetcode.structure.singlylinkedlist.ListNode;

public class Problem21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode a, b, t;
        if (l1.val < l2.val) {
            a = l1;
            b = l2;
        } else {
            a = l2;
            b = l1;
        }
        t = a;
        while (t.next != null) {
            if (t.next.val < b.val) {
                t = t.next;
            } else {
                break;
            }
        }
        t.next = mergeTwoLists(b, t.next);
        return a;
    }

}
