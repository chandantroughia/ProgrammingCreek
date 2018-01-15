package Tree;

public class ValidateBST {
    /**
     * Definition for a binary/BS tree node.
     *               50
     *            /     \
     *           25     75
     *         /   \   /   \
     *        15  35  55   85
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean validateBST(TreeNode root){
        return validateBstUtil(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean validateBstUtil(TreeNode root, int max, int min){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return validateBstUtil(root.left, root.val, min) && validateBstUtil(root.right, max, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(35);
        root.right = new TreeNode(75);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(85);

        boolean result = validateBST(root);
        System.out.println(result);
    }
}
