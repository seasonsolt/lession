package leetcode;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 3:59 PM 2018/12/20
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST (root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST (TreeNode root, long min, long max)    {
        if (root == null) return true;
        return (root.val > min &&
                root.val < max &&
                isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max));
    }


    public static void main(String[] args) {
        int[] arr= {3,1,5,0,2,4,6};
        TreeNode root = new TreeNode(5);
        TreeNode node = root.levelArrToTree(arr);

        ValidateBinarySearchTree test = new ValidateBinarySearchTree();

        boolean isValidate = test.isValidBST(node);

        System.out.println(isValidate);
    }
}
