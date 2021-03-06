package Tree;

import java.util.Stack;

public class PostorderTraversal {

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

    public static void postorderTraversal(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> theStack = new Stack<>();
        theStack.push(root);

        while(!theStack.isEmpty()){
            TreeNode top = theStack.peek();
            if(top.left == null && top.right == null){
                System.out.print(top.val + " ");
                theStack.pop();
            }else{
                if(top.right != null){
                    theStack.push(top.right);
                    top.right = null;
                }
                if(top.left != null){
                    theStack.push(top.left);
                    top.left = null;
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(35);
        root.right = new TreeNode(75);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(85);

        postorderTraversal(root);
    }
}
