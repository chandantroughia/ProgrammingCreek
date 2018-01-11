package ClassicProblems;

public class ReverseInGroupsOfK {

    private Node head;

    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    private int len(Node n){
        int count = 0;
         while (n != null){
             n = n.next;
             count++;
         }
         return count;
    }

    //Recursively
    public Node reverseRecur(Node head, int k){
        if(len(head) < k){
            return head;
        }

        int count = 0;
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null & count != k){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(head != null){
            head.next = reverseRecur(next, k);
        }
        return prev;
    }

    private Node reverse(Node pre, Node next){
        Node last = pre;
        Node curr = last.next;
        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
        return last;
    }

    //Iteratively
    public Node reverseIter(Node head, int k){
        if(head == null || k == 1) return head;
        Node fake = new Node(0);
        fake.next = head;
        Node prev = fake;
        Node p = head;
        int i = 0;
        while(p != null){
            i++;
            if(i % k == 0){
                prev.next = reverse(prev, p.next);
                p = prev.next;
            }else{
                p = p.next;
            }
        }
        return fake.next;
    }
}
