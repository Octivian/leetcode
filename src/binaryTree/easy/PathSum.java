package binaryTree.easy;

public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            return traversal(root, root.val, sum);
        }

        public boolean traversal(TreeNode root, int t, int sum) {
            if (root.left == null && root.right == null) {
                return t == sum ? true : false;
            }
            boolean b1 = false;
            boolean b2 = false;
            if (root.left != null) {
                b1 = traversal(root.left, root.left.val + t, sum);
            }
            if (root.right != null) {
                b2 = traversal(root.right, root.right.val + t, sum);
            }
            return b1 || b2;
        }
    }
}
