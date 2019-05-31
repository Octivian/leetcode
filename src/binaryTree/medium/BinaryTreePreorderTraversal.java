package binaryTree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * iterator
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();
            List<Integer> r = new ArrayList<>();
            if (root == null) {
                return r;
            }
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode peek = stack.pop();
                r.add(peek.val);
                TreeNode left = peek.left;
                TreeNode right = peek.right;
                if (right != null) {
                    stack.push(right);
                }
                if (left != null) {
                    stack.push(left);
                }
            }
            return r;
        }
    }

    /**
     * recursion
     */
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            traversal(root, r);
            return r;
        }

        public void traversal(TreeNode root, List<Integer> r) {
            if (root != null) {
                r.add(root.val);
                traversal(root.left, r);
                traversal(root.right, r);
            }
        }
    }
}
