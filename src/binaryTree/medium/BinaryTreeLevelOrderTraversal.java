package binaryTree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> r = new ArrayList<>();
            if (root == null) {
                return r;
            }
            LinkedList<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> rr = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode peek = q.remove();
                    rr.add(peek.val);
                    if (peek.left != null) {
                        q.offer(peek.left);
                    }
                    if (peek.right != null) {
                        q.offer(peek.right);
                    }


                }
                r.add(rr);
            }
            return r;
        }
    }
}
