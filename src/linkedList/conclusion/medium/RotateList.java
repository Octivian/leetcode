package linkedList.conclusion.medium;

public class RotateList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode r = new ListNode(0);
            r.next = head;
            int cnt = 1;
            ListNode tail = head;
            ListNode tmp = head;
            while (tail.next != null) {
                tail = tail.next;
                cnt++;
            }

            int realK = cnt - (k % cnt);

            for (int i = realK - 1; i > 0; i--) {
                tmp = tmp.next;
            }
            tail.next = r.next;
            r.next = tmp.next;
            tmp.next = null;
            return r.next;
        }
    }
}
