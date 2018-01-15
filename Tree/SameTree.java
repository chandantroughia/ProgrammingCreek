package Tree;

public class SameTree {
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

    private static boolean sameTree(TreeNode one, TreeNode two){
        if(one == null && two == null) return true;
        if(one == null || two == null) return false;
        return sameTree(one.left, two.left) && sameTree(one.right, two.right) && one.val == two.val;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(50);
        root1.left = new TreeNode(25);
        root1.left.left = new TreeNode(15);
        root1.left.right = new TreeNode(35);
        root1.right = new TreeNode(75);
        root1.right.left = new TreeNode(55);
        root1.right.right = new TreeNode(85);

        TreeNode root2 = new TreeNode(50);
        root2.left = new TreeNode(25);
        root2.left.left = new TreeNode(15);
        root2.left.right = new TreeNode(35);
        root2.right = new TreeNode(75);
        root2.right.left = new TreeNode(55);
        root2.right.right = new TreeNode(85);

        /* returns true for above tree */
        boolean result = sameTree(root1, root2);
        System.out.println(result);
    }
}
