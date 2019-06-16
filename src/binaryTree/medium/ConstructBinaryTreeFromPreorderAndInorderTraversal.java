package binaryTree.medium;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, inorder, 0, inorder.length - 1, 0);
        }

        public TreeNode build(int[] preorder, int[] inorder, int is, int ie, int pp) {
            if (is > ie) {
                return null;
            }
            TreeNode node = new TreeNode(preorder[pp]);
            int i = 0;
            for (; i < inorder.length; i++) {
                if (inorder[i] == node.val)
                    break;
            }
            node.left = build(preorder, inorder, is, i - 1, pp + 1);
            node.right = build(preorder, inorder, i + 1, ie, pp + 1 + i - is);
            return node;
        }
    }
}
