package Tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

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

    public static void preorderTraversal(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public static void invertBinaryTreeRecursive(TreeNode root){
        if(root != null){
            helper(root);
        }
        else return;
    }

    private static void helper(TreeNode p){
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        if(p.left != null){
            helper(p.left);
        }
        if(p.right != null){
            helper(p.right);
        }
    }

    public static void invertBinaryTreeIteratively(TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return;
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode p = q.poll();
            if(p.left != null){
                q.offer(p.left);
            }
            if(p.right != null){
                q.offer(p.right);
            }
            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
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

        preorderTraversal(root);
        System.out.println();

        invertBinaryTreeRecursive(root);
        preorderTraversal(root);
        System.out.println();

        invertBinaryTreeIteratively(root);
        preorderTraversal(root);
    }
}
