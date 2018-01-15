package Tree;

import java.util.Stack;

public class InorderTraversal {

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


    public static void inorderTraversal(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> theStack = new Stack<>();
        theStack.push(root);

        while(!theStack.isEmpty()){
            TreeNode top = theStack.peek();
            if(top.left != null){
                theStack.push(top.left);
                top.left = null;
            }
            else{
                TreeNode temp = theStack.pop();
                System.out.print(temp.val + " ");
                if(temp.right != null){
                    theStack.push(temp.right);
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

        inorderTraversal(root);
    }

}
