package Tree;

import java.util.LinkedList;

public class PathSumI {
    /**
     * Definition for a binary/BS tree node.
     *              5
     *             / \
     *            4   8
     *           /   / \      return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     *          11  13  4
     *         /  \      \
     *        7    2      1
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean hasPathSumIteratively(TreeNode root, int sum){
        if(root == null) return false;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> values = new LinkedList<>();
        nodes.add(root);
        values.add(root.val);

        while(!nodes.isEmpty()){
            TreeNode temp = nodes.poll();
            int value = temp.val;

            if(temp.left == null && temp.right == null && value == sum){
                return true;
            }

            if(root.left != null){
                nodes.add(root.left);
                values.add(value + root.left.val);
            }

            if(root.right != null){
                nodes.add(root.right);
                values.add(value + root.right.val);
            }
        }

        return false;
    }

    public static boolean hasPathSumRecursively(TreeNode root, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null && sum == 0) return true;
        return hasPathSumRecursively(root.left, sum - root.val) || hasPathSumRecursively(root.right, sum - root.val);
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
        root.right.left = new TreeNode(13);

        System.out.println(hasPathSumIteratively(root, 22));
        System.out.println(hasPathSumRecursively(root, 22));
        System.out.println("Done");
    }
}
