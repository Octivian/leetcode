package linkedList.conclusion.medium;

public class CopyListWithRandomPointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {

            Node tmp = head;
            while (tmp != null) {
                Node next = tmp.next;
                tmp.next = new Node(tmp.val, tmp.next, tmp.random);
                tmp = next;
            }

            Node r = head == null ? null : head.next;
            tmp = head;
            while (tmp != null && tmp.next != null) {
                Node tmpR = tmp.next;
                tmpR.random = tmp.random == null ? null : tmp.random.next;
                tmp = tmp.next.next;
            }
            tmp = head;
            while (tmp != null) {
                Node tmpR = tmp.next;
                Node tmpONext = tmpR.next;
                tmpR.next = tmpONext == null ? null : tmpONext.next;
                tmp.next = tmpONext;
                tmp = tmp.next;
            }
            return r;
        }
    }
}
