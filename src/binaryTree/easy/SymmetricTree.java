package binaryTree.easy;

public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return traversal(root.left, root.right);
        }

        public boolean traversal(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left == null || right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            }

            boolean b1 = traversal(left.left, right.right);
            boolean b2 = traversal(left.right, right.left);

            return b1 && b2;
        }
    }
}
