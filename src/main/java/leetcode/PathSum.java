package leetcode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> reMap = new HashMap<Integer, Integer>();

        pathSum(root, sumMap, reMap, 0);
        return reMap.containsKey(sum);
    }

    public void pathSum(TreeNode node, Map<Integer, Integer> sumMap,  Map<Integer, Integer> reMap, int parentHash) {
        if(null == node){
            return;
        }

        if(null == node.left && null == node.right){
           //leaf node
            reMap.put(sumMap.getOrDefault(parentHash,0) + node.val, 1);
        }
        sumMap.put(node.hashCode(), sumMap.getOrDefault(parentHash,0) + node.val);
//        sumMap.remove(parentVal);
        if (null != node.left){
           pathSum(node.left, sumMap, reMap, node.hashCode());
        }
        if (null != node.right){
            pathSum(node.right, sumMap, reMap, node.hashCode());
        }
    }


    public static void main(String[] args) {
        PathSum test = new PathSum();

        TreeNode root = new TreeNode(5);

        int arr[] = {5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 0, 1};
        int arr1[] = {1,-2,-3,1,3,-2,0,-1};
//        TreeNode node = root.levelArrToTree(arr1);

//        System.out.print(test.hasPathSum(node, 22));


    }
}
