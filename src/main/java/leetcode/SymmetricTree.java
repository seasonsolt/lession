package leetcode;

import java.util.List;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(null == root){
            return false;
        }
        String left = leftOrder(root.left);
        String right = rightOrder(root.right);

        return left.equals(right);
    }

    public String leftOrder(TreeNode node){
        if(null == node){
            return "null";
        }
        return  leftOrder(node.left ) + leftOrder(node.right) + node.val;
    }

    public String rightOrder(TreeNode node){
        if(null == node){
            return "null";
        }
        return  rightOrder(node.right) + rightOrder(node.left) + node.val;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree test = new SymmetricTree();
        System.out.println(test.isSymmetric(root));
    }
}
