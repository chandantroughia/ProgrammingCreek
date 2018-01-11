package ClassicProblems;

public class RemoveDupesFromSortedLinkedLists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int d) {
            val = d;
            next = null;
        }
    }


    /*
        Given 1->1->2, return 1->2.
        Given 1->1->2->3->3, return 1->2->3.
     */

    public ListNode removeDuplicatesI(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode p = head;

        while(p != null && p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }

        return head;
    }

    /*
        For example, given 1->1->1->2->3, return 2->3.
     */

    public ListNode removeDuplicatesII(ListNode head){

        ListNode newNode = new ListNode(0);
        newNode.next = head;

        ListNode p = newNode;

        while(p.next != null && p.next.next != null){
            if(p.next.val == p.next.next.val){
                int duplicate = p.next.val;
                while(p.next != null && p.next.val == duplicate){
                    p.next = p.next.next;
                }
            }else{
                p = p.next;
            }
        }
        return newNode.next;
    }
}
