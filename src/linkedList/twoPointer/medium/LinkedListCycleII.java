package linkedList.twoPointer.medium;

public class LinkedListCycleII {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Test Case 中的元素的val可能相同，所以还要判断next的val
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode s = head;
            ListNode f = head;
            while (f.next != null && f.next.next != null) {
                s = s.next;
                f = f.next.next;
                if (s.val == f.val && s.next.val == f.next.val) {
                    s = head;
                    while (s.val != f.val || s.next.val != f.next.val) {
                        s = s.next;
                        f = f.next;
                    }
                    return s;
                }
            }
            return null;
        }
    }
}
