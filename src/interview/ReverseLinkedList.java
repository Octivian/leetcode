package interview;

public class ReverseLinkedList {
    static class Node {
        int val;
        Node next;
    }

    static Node reverse(Node n) {
        Node r = null;
        while (n != null) {
            Node tmp = n.next;
            n.next = r;
            r = n;
            n = tmp;
        }
        return r;
    }

    public static void main(String[] args) {

        Node d = new Node();
        d.next = null;
        d.val = 4;
        Node c = new Node();
        c.next = d;
        c.val = 3;
        Node b = new Node();
        b.next = c;
        b.val = 2;
        Node a = new Node();
        a.next = b;
        a.val = 1;
        Node r = reverse(a);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
