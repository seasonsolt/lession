package leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode levelArrToTree(int[] arr){
        if(arr.length < 1){
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        levelArrToSubTree(root, arr, 0);

        return root;
    }
    public void levelArrToSubTree(TreeNode root, int[] arr, int index){
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
            levelArrToSubTree(root.left, arr, 2 * index + 1);
        }
        if(null != root.right){
            levelArrToSubTree(root.right, arr, 2 * index + 2);
        }
    }
}
