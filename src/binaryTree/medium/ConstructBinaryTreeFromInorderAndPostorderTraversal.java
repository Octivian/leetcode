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
            return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode build(int[] inorder, int[] postorder, int ppos, int ins, int ine) {
            if (ins > ine) {
                return null;
            }
            TreeNode node = new TreeNode(postorder[ppos]);
            int mid = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == postorder[ppos]) {
                    mid = i;
                }
            }
            int rightNodeIndex = ppos - 1; // postorder
            int rightNodeNums = ine - mid; //inorder
            int leftNodeIndex = rightNodeIndex - rightNodeNums;
            node.left = build(inorder, postorder, leftNodeIndex, ins, mid - 1);
            node.right = build(inorder, postorder, rightNodeIndex, mid + 1, ine);
            return node;
        }
    }
}
