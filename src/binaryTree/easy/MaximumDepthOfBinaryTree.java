package binaryTree.easy;

public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * top to bottom
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            return traversal(root, 0);
        }

        public int traversal(TreeNode root, int r) {
            if (root == null) {
                return r;
            }
            int r1 = traversal(root.left, r + 1);
            int r2 = traversal(root.right, r + 1);
            return Math.max(r1, r2);
        }
    }

    /**
     * bottom to top
     */
    class Solution1 {
        public int maxDepth(TreeNode root) {
            return traversal(root, 0);
        }

        public int traversal(TreeNode root, int r) {
            if (root == null) {
                return r;
            }
            int r1 = traversal(root.left, r);
            int r2 = traversal(root.right, r);
            return Math.max(r1, r2) + 1;
        }
    }
}
