package ClassicProblems;

public class ReverseLinkedListII {
    private Node head;

    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public Node reverse(Node head, int m, int n){
        if(head == null) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for(int i = 0; i < m - 1; i++){
            prev = prev.next;
        }

        Node start = prev;
        Node then = prev.next;

        for(int i = 0; i < n - m; i++){
            prev.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
