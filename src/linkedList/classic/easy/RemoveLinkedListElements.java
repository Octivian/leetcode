package linkedList.classic.easy;

public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode s = head;
            ListNode f = head.next;
            while (f != null) {
                if (f.val == val) {
                    s.next = s.next.next;
                    f = s.next;
                } else {
                    s = s.next;
                    f = f.next;
                }
            }
            return head = head.val == val ? head.next : head;
        }
    }

    /**
     * recursion
     */
    class Solution1 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }
}
