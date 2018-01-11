package ClassicProblems;

/*
    Given:   h --> 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6
 */

public class SwapPairs {
    private Node head;

    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public Node swapPairs(Node head){
        if(head == null || head.next == null) return head;
        Node temp = head;
        while(temp != null && temp.next != null){
            int k = temp.val;
            temp.val = temp.next.val;
            temp.next.val = k;
            temp = temp.next.next;
        }
        return head;
    }

    public void swapPairsResursive(Node head){
        if(head !=  null && head.next != null){
            swap(head.val, head.next.val);
            swapPairsResursive(head.next.next);
        }
    }

    public void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }
}
