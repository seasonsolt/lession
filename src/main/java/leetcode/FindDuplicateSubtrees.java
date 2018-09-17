package leetcode;

import javax.transaction.TransactionRequiredException;
import java.util.*;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * Example 1:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * The following are two duplicate subtrees:
 *
 *       2
 *      /
 *     4
 * and
 *
 *     4
 * Therefore, you need to return above trees' root in the form of a list.
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> dupMap = new HashMap<String, Integer>();
        Map<String, TreeNode> resultMap = new HashMap<String, TreeNode>();
        treeToString(root, dupMap, resultMap);

        return new ArrayList<TreeNode>(resultMap.values());
    }

    public String treeToString(TreeNode root, Map<String, Integer> dupMap,  Map<String, TreeNode> resultMap) {
        if(null == root){
            return "x";
        }
        String leftVal = "x", rightVal = "x", val = "";
        if(null != root.left){
            leftVal = treeToString(root.left, dupMap, resultMap);
        }
        if(null != root.right){
            rightVal = treeToString(root.right, dupMap, resultMap);
        }

        val = root.val + leftVal + rightVal;
        System.out.println(val);
        if(null != dupMap.put(val, 1)){
           resultMap.put(val, root);
        }

        return val;
    }

    public TreeNode stringToTree(int[] arr){
        if(arr.length < 1){
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        stringToSingleTree(root, arr, 0);

        return root;
    }
    public void stringToSingleTree(TreeNode root, int[] arr, int index){
        if(null == root){
            return;
        }
        if((2 * index + 1) < arr.length ){
            root.left =  0 == arr[2 * index + 1] ? null : new TreeNode(arr[2 * index + 1]);
        }else {
           root.left = null;
        }
        if((2 * index + 2) < arr.length ){
            root.right =  0 == arr[2 * index + 2] ? null : new TreeNode(arr[2 * index + 2]);
        }else {
            root.right = null;
        }

        if(null != root.left){
            stringToSingleTree(root.left, arr, 2 * index + 1);
        }
        if(null != root.right){
            stringToSingleTree(root.right, arr, 2 * index + 2);
        }
    }


    public static void main(String[] args){
        FindDuplicateSubtrees test = new FindDuplicateSubtrees();
//        int[] arr = {1,2,3,4,0,2,4,0,0,0,0,4};
        int[] arr = {1,1,1,1,0,0,1,0,0,0,0,0,0,0,1};
        TreeNode root = test.stringToTree(arr);
        System.out.println(test.findDuplicateSubtrees(root).toString());
    }
}
