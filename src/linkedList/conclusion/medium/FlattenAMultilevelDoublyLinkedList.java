package linkedList.conclusion.medium;

public class FlattenAMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    //my pointer solution, 到链表尾部，level不为0，向左，这一步完全多余
    class Solution {
        public Node flatten(Node head) {
            Node r = head;
            int level = 0;
            while (r != null || level != 0) {

                if (r.child != null) {
                    //有儿子，向下，层级加1
                    r.child.prev = r;
                    r = r.child;
                    level++;
                } else if (r.next == null && level != 0) {
                    //到链表尾部，level不为0，向左（完全多余）
                    Node tail = r;
                    while (r.prev.next == r) {
                        r = r.prev;
                    }
                    r.prev.child = null;
                    tail.next = r.prev.next;
                    r.prev.next = r;
                    if (tail.next != null) {
                        tail.next.prev = tail;
                    }
                    r = tail;
                    level--;
                } else {
                    r = r.next;
                }
            }
            return head;
        }
    }

    //awesome pointer solution
    class Solutio1n {
        public Node flatten(Node head) {
            Node r = head;
            while (r != null) {
                if (r.child == null) {
                    r = r.next;
                    continue;
                }
                Node tmp = r.child;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = r.next;
                if (tmp.next != null) {
                    tmp.next.prev = tmp;
                }
                r.next = r.child;
                r.child.prev = r;
                r.child = null;
                r = r.next;
            }
            return head;
        }
    }
}
