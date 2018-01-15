package Tree;

import apple.laf.JRSUIUtils;

import java.util.Stack;

public class BstIterator {

    /**
     * Definition for a binary/BS tree node.
     *                 8
     *               /   \
     *             3      10
     *            / \      \
     *           1   6     14
     *              / \    /
     *             4  7  13
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /* This can be implemented using a stack, we need to create a stack to save the TreeNode and this stack needs
     * to be static, because all three functions will use this stack.
     */

    private static Stack<TreeNode> theStack;

    private static void BSTIterator(TreeNode root){
        theStack = new Stack<TreeNode>();
        while(root != null){
            theStack.push(root);
            root = root.left;
        }
    }

    private static boolean hasNext(){
        return !theStack.isEmpty();
    }

    private static int next(){
        TreeNode nodeToBeReturned = theStack.pop();
        TreeNode right = nodeToBeReturned.right;
        while(right != null){
            theStack.push(right);
            right = right.left;
        }
        return nodeToBeReturned.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        BSTIterator(root);
        System.out.println(hasNext());
        System.out.println(next());
        System.out.println(next());

    }
}
