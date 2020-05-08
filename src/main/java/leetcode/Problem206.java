package leetcode;

public class Problem206 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" + val + '}';
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = head, cur = head.next, next;
        head.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }

    public static void main(String[] args) {
        Problem206 problem = new Problem206();
        ListNode listNode = problem.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        System.out.println(listNode.val);
    }

}
