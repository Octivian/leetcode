package binaryTree.medium;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    Too hard

    todo
     */
    class Solution {
        int[] iArray;
        int[] pArray;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int size = inorder.length;
            iArray = inorder;
            pArray = postorder;
            if (size == 0) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[size - 1]);
            TreeNode tmp = root;
            return root;
        }

        public void build(TreeNode root) {

        }
    }
}
