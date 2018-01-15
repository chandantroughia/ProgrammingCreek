package Tree;

public class LCAofBTree {
    /**
     * Definition for a binary/BS tree node.
     *               50
     *            /     \
     *           25     75
     *         /   \   /   \
     *        100  35  55   15
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode getLCA(TreeNode root, int one , int two){
        if(root == null) return null;
        if(root.val == one || root.val == two){
            return root;
        }

        TreeNode left = getLCA(root.left, one, two);
        TreeNode right = getLCA(root.right, one, two);

        if(left == null && right == null) return null;
        else if(left != null && right != null) return root;
        else return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.left.left = new TreeNode(100);
        root.left.right = new TreeNode(35);
        root.right = new TreeNode(75);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(15);

        TreeNode result = getLCA(root, 55, 15);
        System.out.println(result.val);
    }
}
