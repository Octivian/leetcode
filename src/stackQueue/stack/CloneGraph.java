package stackQueue.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    class Solution {
        public Node cloneGraph(Node node) {
            Map<Node, Node> map = new HashMap<Node, Node>();
            return DFS(node, map);
        }

        private Node DFS(Node node, Map<Node, Node> map) {
            if (map.containsKey(node)) {
                return map.get(node);
            }

            map.put(node, new Node(node.val, new ArrayList<Node>()));
            for (Node n : node.neighbors) {
                //这两行等价，返回neighbors顺序不一样而已，leetcode过不去
//                DFS(n, map).neighbors.add(map.get(node));
                map.get(node).neighbors.add(DFS(n, map));
            }
            return map.get(node);
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }


}
