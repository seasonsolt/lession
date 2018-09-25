package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
 * Example:
 *
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        Map<Integer, List<TreeLinkNode>> levelList = new HashMap<Integer, List<TreeLinkNode>>();
        doConnect(root, levelList, 0);

        for (Integer in : levelList.keySet()) {
            for(int i = 0; i < levelList.get(in).size() - 1; i++){
                levelList.get(in).get(i).next = levelList.get(in).get(i+1);
            }
        }
    }
    public void doConnect(TreeLinkNode root, Map<Integer, List<TreeLinkNode>> levelList, int level) {
        if(null == root){
            return;
        }
        if(null == levelList.get(level)){
            List<TreeLinkNode> listNode = new LinkedList<TreeLinkNode>();
            listNode.add(root);
            levelList.put(level, listNode);
        }else {
           levelList.get(level).add(root);
        }

        doConnect(root.left, levelList, level + 1);
        doConnect(root.right, levelList, level + 1);
    }

    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);

        PopulatingNextRightPointersinEachNodeII test = new PopulatingNextRightPointersinEachNodeII();
        test.connect(root);;
        System.out.println(root);
    }
}
