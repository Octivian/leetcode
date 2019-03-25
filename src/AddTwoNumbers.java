public class AddTwoNumbers {
    /**
     * Time Comlexity O(N)
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int sum = l1.val + l2.val;

            ListNode targetNode = new ListNode(sum % 10);
            ListNode preNode = targetNode;
            ListNode curNode;

            int ten = sum < 10 ? 0 : 1;

            l1 = l1.next;
            l2 = l2.next;

            while (l1 != null || l2 != null || ten != 0) {

                int l1val = l1 == null ? 0 : l1.val;
                int l2val = l2 == null ? 0 : l2.val;
                sum = l1val + l2val + ten;

                curNode = new ListNode(sum % 10);
                preNode.next = curNode;
                preNode = curNode;

                ten = sum < 10 ? 0 : 1;

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            return targetNode;
        }
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
