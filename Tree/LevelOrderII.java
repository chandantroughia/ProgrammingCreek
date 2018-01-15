package Tree;

import java.util.*;

public class LevelOrderII {

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


    public static void levelOrderTraversalReverse(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        q.offer(root);

        while(!q.isEmpty()){

                TreeNode head = q.poll();
                s.push(head);

                if(head.right != null){
                    q.offer(head.right);
                }

                if(head.left != null){
                    q.offer(head.left);
                }
        }

        while (!s.isEmpty()){
            System.out.print(s.pop().val + " ");
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

        levelOrderTraversalReverse(root);
    }

}