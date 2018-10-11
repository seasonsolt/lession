package leetcode;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 3:28 PM 2018/9/26
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 * according to the LCA definition.
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
        /*
        if (left == null) {
            return right;
        } else {
            if (right == null)
                return left;
            else {
                return root;
            }
        }i*/
    }

    public static void main(String[] args) {
        LowestCommonAncestorofaBinaryTree test = new LowestCommonAncestorofaBinaryTree();
        String treeStr = "[3,5,1,6,2,0,8,null,null,7,4]";
        SerializeandDeserializeBinaryTree serialTree = new SerializeandDeserializeBinaryTree();
        TreeNode root = serialTree.deserialize(treeStr);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        TreeNode res = test.lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }

}
