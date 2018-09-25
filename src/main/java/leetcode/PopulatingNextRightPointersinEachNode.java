package leetcode;

/**
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        doConnect(root);
    }
    public void doConnect(TreeLinkNode root) {
        if(null == root){
            return;
        }
        if(null != root.left && null != root.right){
            root.left.next = root.right;
            if(null != root.next){
                root.right.next = root.next.left;
            }
        }else{
            return;
        }
        doConnect(root.left);
        doConnect(root.right);
    }



    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(0);
        root.left = new TreeLinkNode(1);
        root.right = new TreeLinkNode(2);
        root.left.left = new TreeLinkNode(3);
        root.left.right = new TreeLinkNode(4);
        root.right.left= new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(6);

        PopulatingNextRightPointersinEachNode test = new PopulatingNextRightPointersinEachNode();
        test.doConnect(root);;
        System.out.println(root);

    }


}
