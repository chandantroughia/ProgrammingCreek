package Tree;

import java.util.Stack;

public class FlattenBinaryTree {
    /**
     * Definition for a binary/BS tree node.
     *               1
     *            /     \
     *           2       5         ---->  1 - 2 - 3 - 4 - 5 - 6
     *         /   \      \
     *        3    4       6
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void flattenBinaryTree(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while(p != null || !s.isEmpty()){

            if(p.right != null){
                s.push(p.right);
            }

            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }
            else if(!s.isEmpty()){
                TreeNode temp = s.pop();
                p.right = temp;
            }
            p = p.right;
        }
    }

    public static void printList(TreeNode root){
        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flattenBinaryTree(root);
        printList(root);
    }
}
