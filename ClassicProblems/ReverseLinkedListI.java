package ClassicProblems;

public class ReverseLinkedListI {
    private Node head;

    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public Node reverseIterative(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node current = head;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = current.next;
        }
        return prev;
    }

    public Node reverseRecursively(Node head){
        if(head == null || head.next == null) return null;
        Node prev = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}
