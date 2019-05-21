package linkedList.twoPointer.easy;

public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode s = head;
            ListNode f = head;
            while (f.next != null && f.next.next != null) {
                s = s.next;
                f = f.next.next;
                if (s.val == f.val) {
                    return true;
                }
            }
            return false;
        }
    }
}
