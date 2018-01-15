package Tree;

public class LCAofBST {

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

    private static TreeNode getLCA(TreeNode root, int one , int two){
        TreeNode m = root;
        if(m.val > one && m.val < two){
            return m;
        }
        else if(one < m.val && two < m.val){
            return getLCA(root.left, one, two);
        }
        else if(one > m.val && two > m.val){
            return getLCA(root.right, one, two);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(35);
        root.right = new TreeNode(75);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(85);

        TreeNode result = getLCA(root, 15, 35);
        System.out.println(result.val);
    }
}
