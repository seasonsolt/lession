package leetcode;

import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 上午9:25 2018/9/21
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return root == null ? "null" : root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data, new int[]{0});
    }

    public TreeNode deserialize(String data, int[] start) {
        int index = data.indexOf(' ', start[0]);
        if(index == -1) return null;

        String val = data.substring(start[0], index);
        start[0] = index + 1;

        if(val.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left  = deserialize(data, start);
        root.right = deserialize(data, start);
        return root;
    }

    public static void main(String args[]) {
        SerializeandDeserializeBinaryTree test = new SerializeandDeserializeBinaryTree();
        String testStr = "[1,2,3,null,null,4,5]";

        TreeNode root = test.deserialize(testStr);
        System.out.println(root);

        String seStr = test.serialize(root);
        System.out.println(seStr);
        System.out.println(seStr.equals(testStr));
    }


}
