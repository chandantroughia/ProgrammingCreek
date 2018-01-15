package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightAndLeftViewOfTree {

    /**
     * Definition for a binary/BS tree node.
     *                 1
     *               /   \                Right View -> 1, 3, 5
     *              2    3                Left View  -> 1, 2, 5
     *              \
     *              5
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static void rightViewIteratively(TreeNode root){
        if(root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode top = queue.poll();

                //first element in the queue is the right most at each level
                if(i == 0){
                    System.out.print(top.val + " ");
                }

                //add right first
                if(top.right != null){
                    queue.offer(top.right);
                }

                //then add left
                if(top.left != null){
                    queue.offer(top.left);
                }
            }
        }
        System.out.println();
    }

    private static void leftViewIteratively(TreeNode root){
        if(root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode top = queue.poll();

                //first element in the queue is the left most at each level
                if(i == 0){
                    System.out.print(top.val + " ");
                }

                //add left first
                if(top.left != null){
                    queue.offer(top.left);
                }

                //then add right
                if(top.right != null){
                    queue.offer(top.right);
                }
            }
        }
        System.out.println();
    }

    /* To use recursion we need to make a static variable called max_level and set it to 0 */

    private static int max_level = 0;

    private static void rightViewRec(TreeNode root, int level){
        if(root == null) return;
        if(max_level < level){
            System.out.print(root.val + " ");
            max_level = level;
        }
        rightViewRec(root.right, level + 1);
        rightViewRec(root.left, level + 1);
    }

    private static void leftViewRec(TreeNode root, int level){
        if(root == null) return;
        if(max_level < level){
            System.out.print(root.val + " ");
            max_level = level;
        }
        rightViewRec(root.left, level + 1);
        rightViewRec(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println("Right View Iteratively: ");
        rightViewIteratively(root);

        System.out.println("Left View Iteratively: ");
        leftViewIteratively(root);

        /* need few cahnges to do this recursively */
        System.out.println("Right View Recursively: ");
        rightViewRec(root, 1);
        System.out.println();

        //reset the max_level
        max_level = 0;
        System.out.println("Left View Recursively: ");
        leftViewRec(root, 1);
    }
}
