package Tree;

public class MaximumPathSum {

    /**
     * Definition for a binary/BS tree node.
     *               1
     *            /     \
     *           2       5        --> should return 19 for this example
     *         /   \   /   \
     *        3    4  6    7
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int getMaxPathSum(TreeNode root, int[] result){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return root.val;
        }

        int ls = getMaxPathSum(root.left, result);
        int rs = getMaxPathSum(root.right, result);

        if(root.left != null && root.right != null){
            result[0] = Math.max(result[0], ls + rs + root.val);
            return Math.max(ls, rs) + root.val;
        }

        return root.left == null ? rs + root.val: ls + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //to save the results we use a variable
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        getMaxPathSum(root, result);
        System.out.println(result[0]);
    }
}
