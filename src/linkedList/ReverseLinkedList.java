package linkedList;

public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode left = null;
            while (head != null) {
                ListNode tmp = head.next;
                head.next = left;
                left = head;
                head = tmp;
            }
            return left;
        }
    }
}
