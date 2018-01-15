package Tree;

public class SymmetricTree {
    /**
     * Definition for a binary/BS tree node.
     *            1
     *           / \
     *          2   2
     *         / \ / \
     *        3  4 4  3
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return helperUtil(root.left, root.right);
    }

    private static boolean helperUtil(TreeNode one, TreeNode two){
        if(one == null && two == null) return true;
        if(one == null || two == null) return false;
        return one.val == two.val && helperUtil(one.left, two.right) && helperUtil(one.right, two.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = isSymmetric(root);
        System.out.println(result);
    }
}
