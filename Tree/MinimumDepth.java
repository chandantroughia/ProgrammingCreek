package Tree;

import java.util.LinkedList;

public class MinimumDepth {

    /**
     * Definition for a binary/BS tree node.
     *                5
     *               / \
     *             4   8      Result : [ [5,4,11,2], [5,8,4,5] ] to sum = 22
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int minDepthIterative(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> counts = new LinkedList<>();

        nodes.add(root);
        counts.add(1);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();

            if(curr.left == null && curr.right == null){
                return count;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count + 1);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count + 1);
            }
        }
        return 0;
    }

    public static int minDepthRecursive(TreeNode root){
        if(root == null) return 0;
        int leftDepth = minDepthRecursive(root.left);
        int rightDepth = minDepthRecursive(root.right);

        if(Math.min(leftDepth, rightDepth) > 0){
            return Math.min(leftDepth, rightDepth) + 1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        root.right.left = new TreeNode(13);

        System.out.println(minDepthIterative(root));
        System.out.println(minDepthRecursive(root));
    }
}
