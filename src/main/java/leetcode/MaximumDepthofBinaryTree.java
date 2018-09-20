package leetcode;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode node) {
        if (null == node) {
            return 0;
        } else {
            int sumLeft = maxDepth(node.left);
            int sumRight =  maxDepth(node.right);
            return sumLeft >= sumRight ?
                    sumLeft + 1 : sumRight + 1;
        }
    }

    public int reMaxDepth(TreeNode node) {
        if (null == node) {
            return 0;
        } else {
//            return Math.max(reMaxDepth(node.left) + 1, reMaxDepth(node.left) + 1);
            return Math.max(reMaxDepth(node.left) + 1, reMaxDepth(node.right) + 1);
        }

    }

    public final static int max(int a, int b){
        return a >= b ?
                a:b;
    }


    public static void main(String[] args) {

        MaximumDepthofBinaryTree test = new MaximumDepthofBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode p = root;
        for (int i = 0; i < 2000000; i++) {
            p.left = new TreeNode(i);
            p = p.left;
        }
        long s1 = System.currentTimeMillis();
        int r1 = test.reMaxDepth(root);
        long e1 = System.currentTimeMillis();
        System.out.println("s1:" + r1 +  "cost" + (e1 - s1));

        long s2 = System.currentTimeMillis();
        int r2 = test.maxDepth(root);
        long e2 = System.currentTimeMillis();
        System.out.println("s2:" + r2 +  "cost" +(e2 - s2));
    }
}
