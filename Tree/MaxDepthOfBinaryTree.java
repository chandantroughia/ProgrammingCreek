package Tree;

public class MaxDepthOfBinaryTree {

    /**
     * Definition for a binary/BS tree node.
     *               50
     *            /     \
     *           25     75
     *         /   \   /   \
     *        15  35  55   85
     *                      \
     *                      90
     *                       \
     *                       100
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static int getDepth(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getDepth(root.left);
        int rightHeight = getDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(35);
        root.right = new TreeNode(75);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(85);
        root.right.right.right = new TreeNode(90);
        root.right.right.right.right = new TreeNode(100);

        int result = getDepth(root);
        System.out.println(result);
    }
}
