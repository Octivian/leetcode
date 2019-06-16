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

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
        }

        public TreeNode build(int[] inorder, int[] postorder, int is, int ie, int pp) {
            if (is > ie) {
                return null;
            }
            TreeNode node = new TreeNode(postorder[pp]);
            int i = 0;
            for (; i < inorder.length; i++) {
                if (inorder[i] == node.val) {
                    break;
                }
            }
            node.left = build(inorder, postorder, is, i - 1, pp - 1 - (ie - i));
            node.right = build(inorder, postorder, i + 1, ie, pp - 1);
            return node;
        }
    }
}
