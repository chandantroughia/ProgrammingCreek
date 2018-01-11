package ClassicProblems;

public class LinkedListCycle {

    static class ListNode {

        int data;
        ListNode next;

        ListNode(int d) {
            data = d;
            next = null;
        }
    }


    public boolean detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;


        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
