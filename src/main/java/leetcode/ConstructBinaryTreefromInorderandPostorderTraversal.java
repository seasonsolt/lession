package leetcode;

import java.util.Arrays;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode root = doBuildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    TreeNode doBuildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart, int postEnd) {
        while(inStart > inEnd || posStart > postEnd || inStart < 0 || posStart < 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
           if(inorder[i] == root.val){
              rootIndex = i;
           }
        }
        root.left = doBuildTree(inorder, postorder, inStart, rootIndex - 1, posStart, posStart +  rootIndex - 1  - inStart);
        root.right = doBuildTree(inorder, postorder, rootIndex + 1, inEnd, posStart + rootIndex - inStart, postEnd - 1);

        return root;
    }


    public static void main(String[] args){
        ConstructBinaryTreefromInorderandPostorderTraversal test = new ConstructBinaryTreefromInorderandPostorderTraversal();
        int[] inorder = {2,1};
        int[] postorder = {2,1};
        TreeNode root = test.buildTree(inorder, postorder);
        System.out.println(root);

    }



}
