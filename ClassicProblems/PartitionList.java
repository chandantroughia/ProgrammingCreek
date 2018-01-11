package ClassicProblems;

public class PartitionList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }

    public ListNode partition(ListNode root, int x){
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(0);

        ListNode current1 = head;
        ListNode current2 = tail;
        ListNode current = root;

        while(current != null){
            if(current.val < x){
                current1.next = current;
                current1 = current.next;
            }else{
                current2.next = current;
                current2 = current.next;
            }
            current = current.next;
        }

        current2.next = null;
        current1.next = current2;
        return head.next;
    }
}
