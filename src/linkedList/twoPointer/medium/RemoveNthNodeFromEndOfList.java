package linkedList.twoPointer.medium;

public class RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode s = head;
            ListNode f = head;
            int c = 0;
            while (f.next != null) {
                s = c++ < n ? head : s.next;
                f = f.next;
            }
            if (c < n) {
                head = s.next;
            } else {
                s.next = s.next.next;
            }
            return head;
        }
    }
}
