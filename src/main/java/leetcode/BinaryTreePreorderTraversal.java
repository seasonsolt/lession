package leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();

        preOrder(root, list);

        return list;
    }

    public void preOrder(TreeNode node, List<Integer> list){
        if(null == node){
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);

    }

    public  void levelOrder(TreeNode node,  List<List<Integer>> list, int level) {
        if(null == node){
            return;
        }
        if(list.size() - 1 < level || null == list.get(level)){
            List<Integer> levelList = new LinkedList<Integer>();
            levelList.add(node.val);
            list.add(levelList);
        }else{
           list.get(level).add(node.val);
        }

        levelOrder(node.left, list, ++level);
        levelOrder(node.right, list, level);


    }

    public static void main(String[] args){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        BinaryTreePreorderTraversal test = new BinaryTreePreorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left= new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left= new TreeNode(6);
        root.right.right = new TreeNode(7);
//        test.preorderTraversal(root);
        test.levelOrder(root, result, 0);
        System.out.println(result);
    }
}
