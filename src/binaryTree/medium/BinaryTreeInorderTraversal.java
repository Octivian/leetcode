package binaryTree.medium;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            if (root == null) {
                return r;
            }
            if (root == null) {
                return r;
            }
            Set<TreeNode> visited = new HashSet<>();
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            visited.add(root);
            while (!s.isEmpty()) {
                TreeNode pop = s.pop();
                TreeNode left = pop.left;
                TreeNode right = pop.right;
                if (left != null && !visited.contains(left)) {
                    s.push(pop);
                    s.push(left);
                    visited.add(left);
                } else if (right != null && !visited.contains(right)) {
                    s.push(right);
                    s.push(pop);
                    visited.add(right);
                } else {
                    r.add(pop.val);
                }
            }
            return r;
        }
    }


    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            traversal(root, r);
            return r;
        }

        public void traversal(TreeNode root, List<Integer> r) {
            if (root != null) {
                traversal(root.left, r);
                r.add(root.val);
                traversal(root.right, r);
            }
        }
    }
}

