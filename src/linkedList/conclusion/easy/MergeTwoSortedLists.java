package linkedList.conclusion.easy;

public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode tmp = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                }
                tmp = tmp.next;
            }
            tmp.next = l1 == null ? l2 : l1;
            return head.next;
        }
    }
}
