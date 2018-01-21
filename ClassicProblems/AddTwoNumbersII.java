package ClassicProblems;

/*
 *
 *   Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   Output: 7 -> 8 -> 0 -> 7
 *
 * */

class PSum{
    ListNode sum = null;
    int carry = 0;
}

class ListII{

    ListNode head1, head2;

    public int size(ListNode l){
        ListNode current = l;
        int len = 0;
        while(current != null){
            current = current.next;
            len++;
        }
        return len;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = size(l1);
        int len2 = size(l2);
        System.out.println(len1 + " " + len2);

        if(len1 < len2){
            l1 = pad(l1, len2 - len1);
        }else{
            l2 = pad(l2, len1 - len2);
        }

        PSum sum = helperUtil(l1, l2);

        if(sum.carry == 0){
            return sum.sum;
        }else{
            ListNode result = addBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private PSum helperUtil(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            PSum sum = new PSum();
            return sum;
        }

        PSum sum = helperUtil(l1.next, l2.next);
        int val = sum.carry + l1.val + l2.val;

        ListNode result = addBefore(sum.sum, val % 10);
        sum.sum = result;
        sum.carry = val / 10;
        return sum;
    }

    private ListNode pad(ListNode l, int n){
        ListNode head = l;
        for(int i = 0; i < n; i++){
            ListNode newNode = new ListNode(0);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    private ListNode addBefore(ListNode list, int data){
        ListNode newNode = new ListNode(data);
        if(list != null){
            newNode.next = list;
            list = newNode;
        }
        return newNode;
    }
    public void printList(ListNode root){
        while (root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
    }

}


public class AddTwoNumbersII {

    public static void main(String[] args) {
        ListII list = new ListII();
        // creating first list  ----> head -> 7 -> 5 -> 9 -> 4 -> 6
        list.head1 = new ListNode(7);
        list.head1.next = new ListNode(2);
        list.head1.next.next = new ListNode(4);
        list.head1.next.next.next = new ListNode(3);
        System.out.println("First List is ");
        list.printList(list.head1);

        // creating seconnd list ----> head -> 8 -> 4
        list.head2 = new ListNode(5);
        list.head2.next = new ListNode(6);
        list.head2.next.next = new ListNode(4);
        System.out.println("Second List is ");
        list.printList(list.head2);

        // add the two lists and see the result
        ListNode rs = list.addTwoNumbers(list.head1, list.head2);
        System.out.println("Resultant List is ");
        list.printList(rs);
    }
}
