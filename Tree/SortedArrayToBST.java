package Tree;

public class SortedArrayToBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void inorderTraversal(TreeNode root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static TreeNode sortedArrayToBst(int[] nums){
        if(nums.length == 0 || nums == null) return null;
        return helperUtil(nums, 0, nums.length - 1);
    }

    private static TreeNode helperUtil(int[] nums, int low, int high){
        if(low > high){
            return null;
        }
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helperUtil(nums, low, mid - 1);
        root.right = helperUtil(nums, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode node = sortedArrayToBst(arr);
        inorderTraversal(node);
    }
}
