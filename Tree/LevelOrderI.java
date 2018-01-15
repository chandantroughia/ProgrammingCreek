package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderI {

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


    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode head = q.poll();
                temp.add(head.val);

                if(head.left != null){
                    q.offer(head.left);
                }

                if(head.right != null){
                    q.offer(head.right);
                }
            }

            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(35);
        root.right = new TreeNode(75);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(85);

        System.out.println(levelOrderTraversal(root));
    }

}
