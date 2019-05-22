package linkedList.classic.easy;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode r = null;
            while (head != null) {
                ListNode tmp = head.next;
                head.next = r;
                r = head;
                head = tmp;
            }
            return r;
        }
    }

    /**
     * recursion
     */
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //tail没有任何变化，始终是尾节点的引用，只改链表本身节点的相互关系
            ListNode tail = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return tail;
        }
    }
}
