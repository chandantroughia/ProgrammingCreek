package Tree;

public class BalancedBinaryTree {

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

    private static boolean isBalanced(TreeNode root){
        if(root == null) return true;
        if(getHeight(root) == -1) return false;
        return true;
    }

    private static int getHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(rightHeight - leftHeight) > 1) return -1;
        return Math.max(rightHeight, leftHeight) + 1;
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

        boolean result = isBalanced(root);
        System.out.println(result);
    }
}
