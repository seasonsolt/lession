package leetcode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode doBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        //check
        if(preStart > preEnd || inStart > inEnd || preStart < 0 || inStart < 0){
            return null;
        }

        //return
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i = 0; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = doBuildTree(preorder, inorder, preStart + 1, preStart + index - inStart, inStart, index - 1);
        root.right = doBuildTree(preorder, inorder, preStart + 1 + index - inStart, preEnd, index + 1, inEnd);


        return root;
    }

    public static void main(String[] args){
        ConstructBinaryTreefromPreorderandInorderTraversal test = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] inorder = {3,9,20,15,7};
        int[] postorder = {9,3,15,20,7};
        TreeNode root = test.buildTree(inorder, postorder);
        System.out.println(root);

    }
}
