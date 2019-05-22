package linkedList.twoPointer.easy;

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * naive solution
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode h1 = headA;
            ListNode h2 = headB;
            int c1 = 0;
            int c2 = 0;
            while (h1.next != null) {
                h1 = h1.next;
                c1++;
            }
            while (h2.next != null) {
                h2 = h2.next;
                c2++;
            }

            if (h1.val != h2.val) {
                return null;
            }
            h1 = headA;
            h2 = headB;
            if (c2 > c1) {
                h1 = headB;
                h2 = headA;
            }
            int dis = Math.abs(c2 - c1);
            int c = 0;
            while (h1 != h2) {
                h2 = c++ >= dis ? h2.next : h2;
                h1 = h1.next;
            }
            return h1;
        }
    }

    /**
     * awesome solution
     */
    public class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode h1 = headA;
            ListNode h2 = headB;

            /**
             * 让两个指针分别各走一遍AB链表，两个指针就会走一样的距离
             */
            while (h1 != h2) {
                h1 = h1 == null ? headB : h1.next;
                h2 = h2 == null ? headA : h2.next;
            }
            return h1;
        }
    }
}
