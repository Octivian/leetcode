package linkedList.classic.easy;

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        /**
         * 翻转前半段linkedList 直到中点
         */
        public boolean isPalindrome(ListNode head) {
            ListNode s = head;
            ListNode f = head;
            ListNode left = null;
            while (f != null && f.next != null) {
                f = f.next.next;
                ListNode tmp = s.next;
                s.next = left;
                left = s;
                s = tmp;
            }

            /**
             * 奇数个节点情况
             */
            if (f != null && f.next == null) {
                ListNode mid = new ListNode(s.val);
                mid.next = left;
                left = mid;
            }

            while (s != null && left != null) {
                if (s.val != left.val) {
                    return false;
                }
                s = s.next;
                left = left.next;
            }
            return true;
        }
    }
}
