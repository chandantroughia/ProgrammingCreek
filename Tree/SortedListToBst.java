package Tree;

public class SortedListToBst {

    static ListNode current;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    }

    private static void inorderTraversal(TreeNode root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static TreeNode sortedListToBst(ListNode head){
        if(head == null) return null;
        current = head;
        int len = getListLength(head);
        return helperUtil(0, len - 1);
    }

    private static TreeNode helperUtil(int low, int high){
        if(low > high) return null;
        int mid = low + (high - low)/2;

        TreeNode left = helperUtil(low, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helperUtil(mid + 1, high);

        root.left = left;
        root.right = right;

        return root;
    }

    private static int getListLength(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBst(head);
        inorderTraversal(root);
    }
}
