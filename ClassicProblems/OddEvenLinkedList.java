package ClassicProblems;

public class OddEvenLinkedList {

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    public ListNode oddEven(ListNode head){
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
