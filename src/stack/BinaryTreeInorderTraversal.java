package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * recursion for inorder traversal
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            traversal(r, root);
            return r;
        }

        private void traversal(List<Integer> r, TreeNode node) {
            if (node != null) {
                traversal(r, node.left);
                r.add(node.val);
                traversal(r, node.right);
            }
        }
    }

    /**
     * iterate for inorder traversal
     */
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            if (root == null) {
                return r;
            }

            Stack<TreeNode> s = new Stack<>();
            HashSet<TreeNode> set = new HashSet<>();
            s.push(root);
            set.add(root);
            while (!s.isEmpty()) {
                TreeNode peek = s.pop();
                if (peek.right != null && !set.contains(peek.right)) {
                    set.add(peek.right);
                    s.push(peek.right);
                    s.push(peek);
                } else if (peek.left != null && !set.contains(peek.left)) {
                    set.add(peek.left);
                    s.push(peek);
                    s.push(peek.left);
                } else {
                    r.add(peek.val);
                }
            }

            return r;
        }
    }
}
