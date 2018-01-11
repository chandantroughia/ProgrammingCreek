package ClassicProblems;

/*
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class RemoveLinkedListElement {
    private Node head;

    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public Node removeLinkedListElement(Node head, int x){
        Node helper = new Node(0);
        helper.next = head;
        Node p = helper;

        while(p.next != null){
            if(p.next.val == x){
                Node next = p.next;
                p.next = next.next;
            }else{
                p = p.next;
            }
        }
        return helper.next;
    }

}
