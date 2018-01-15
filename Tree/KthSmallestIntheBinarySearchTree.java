package Tree;

import java.util.Stack;

public class KthSmallestIntheBinarySearchTree {
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

    public static TreeNode getKthSmallest(TreeNode root, int k){
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root == null) return null;

        TreeNode p = root;
        while(p != null){
            s.push(p);
            p = p.left;
        }

        int i = 0;
        while(!s.isEmpty()){
            TreeNode t = s.pop();
            i++;

            if(i == k){
                return t;
            }

            TreeNode r = t.right;
            while( r != null){
                s.push(r);
                r = r.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(35);
        root.right = new TreeNode(75);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(85);

        int k = 3;
        TreeNode result = getKthSmallest(root, k);
        System.out.println(result.val);
    }
}
