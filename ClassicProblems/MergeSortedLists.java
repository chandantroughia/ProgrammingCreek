package ClassicProblems;

public class MergeSortedLists {

    static class ListNode {

        int data;
        ListNode next;

        ListNode(int d) {
            data = d;
            next = null;
        }
    }

    public ListNode merge(ListNode one, ListNode two){
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode p1 = one;
        ListNode p2 = two;

        while (p1 != null && p2 != null){
            if(p1.data < p2.data){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null){
            p.next = p1;
        }

        if(p2 != null){
            p.next = p2;
        }

        return head.next;
    }

}
