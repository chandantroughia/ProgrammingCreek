package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

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

    public static List<ArrayList<Integer>> pathSumII(TreeNode root, int sum){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;

        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(root.val);
        dfs(root, sum-root.val, result, l);
        return result;
    }

    public static void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l){
        if(t.left == null && t.right == null && sum == 0){
            ArrayList<Integer> temp = new ArrayList<>(l);
            result.add(temp);
        }

        if(t.left != null){
            l.add(t.left.val);
            dfs(t.left, sum - t.left.val, result, l);
            l.remove(l.size() - 1);
        }

        if(t.right != null){
            l.add(t.right.val);
            dfs(t.right, sum - t.right.val, result, l);
            l.remove(l.size() - 1);
        }
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

        System.out.println(pathSumII(root, 22));
    }
}
