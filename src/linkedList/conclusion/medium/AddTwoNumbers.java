package linkedList.conclusion.medium;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode r = head;
            int bsum = 0;
            while (l1 != null || l2 != null) {
                int l1v = l1 != null ? l1.val : 0;
                int l2v = l2 != null ? l2.val : 0;
                int sum = l1v + l2v + bsum;
                int digit = sum % 10;
                bsum = sum > 9 ? 1 : 0;
                ListNode tmp = new ListNode(digit);
                r.next = tmp;
                r = r.next;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            r.next = bsum == 1 ? new ListNode(1) : null;

            return head.next;
        }
    }
}
