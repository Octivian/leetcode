package linkedList.classic.easy;

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //    class Solution {
    //        public boolean isPalindrome(ListNode head) {
    //            ListNode s = head;
    //            ListNode f = head;
    //            ListNode left = null;
    //            while (f != null && f.next != null && f.next.next != null) {
    //                f = f.next.next;
    //                ListNode tmp = s.next;
    //                s.next = left;
    //                left = s;
    //                s = tmp;
    //            }
    //        }
    //    }
}
