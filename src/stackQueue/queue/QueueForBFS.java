package stackQueue.queue;

import java.util.*;

/**
 * level-order-traversal
 */
public class QueueForBFS {
    static class Node {
        String val;
        List<Node> nodes;
    }

    static void traversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.peek();
                q.remove();
                System.out.println(cur.val);

                List<Node> children = cur.nodes;

                if (children == null) {
                    continue;
                }

                for (Node child : children) {
                    q.offer(child);
                }
            }
        }
    }

    /**
     * add Set for record visited nodes
     *
     * @param root
     */
    static void traversalNodeOnce(Node root) {
        Queue<Node> q = new LinkedList<>();
        Set<Node> visitedSet = new HashSet<>();
        q.offer(root);
        visitedSet.add(root);
        while (q.size() != 0) {
            System.out.println("00000000000");
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.peek();
                q.remove();
                System.out.println(cur.val);

                List<Node> children = cur.nodes;

                if (children == null) {
                    continue;
                }

                for (Node child : children) {
                    if (!visitedSet.contains(child)) {
                        q.offer(child);
                        visitedSet.add(child);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node();
        nodeA.val = "A";

        Node nodeB = new Node();
        nodeB.val = "B";

        Node nodeC = new Node();
        nodeC.val = "C";

        Node nodeD = new Node();
        nodeD.val = "D";

        Node nodeE = new Node();
        nodeE.val = "E";

        Node nodeF = new Node();
        nodeF.val = "F";

        Node nodeG = new Node();
        nodeG.val = "G";

        List<Node> childA = new ArrayList<>();
        childA.add(nodeB);
        childA.add(nodeC);
        childA.add(nodeD);
        nodeA.nodes = childA;

        List<Node> childB = new ArrayList<>();
        childB.add(nodeE);
        nodeB.nodes = childB;

        List<Node> childC = new ArrayList<>();
        childC.add(nodeE);
        childC.add(nodeF);
        nodeC.nodes = childC;

        List<Node> childD = new ArrayList<>();
        childD.add(nodeG);
        nodeD.nodes = childD;

        List<Node> childF = new ArrayList<>();
        childF.add(nodeG);
        nodeF.nodes = childF;

        traversalNodeOnce(nodeA);
    }
}
