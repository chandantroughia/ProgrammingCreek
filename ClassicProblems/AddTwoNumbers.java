package ClassicProblems;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
        this.next = null;
    }
}

class List{

    ListNode head1, head2;

    public ListNode addTwoNodes(ListNode one, ListNode two) {
        ListNode prev = null;
        ListNode result = null;
        ListNode temp = null;
        int sum = 0;

        while (one != null || two != null) {
            sum = sum / 10;

            if (one != null) {
                sum += one.val;
                one = one.next;
            }

            if (two != null) {
                sum += two.val;
                two = two.next;
            }

            temp = new ListNode(sum % 10);

            if (result == null) {
                result = temp;
            }else {
                prev.next = temp;
            }
            prev = temp;
        }
        if(sum / 10 == 1) {
            temp.next = new ListNode(sum/10);
        }
        return result;
    }

    public void printList(ListNode root){
        while (root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {
        List list = new List();
        // creating first list
        list.head1 = new ListNode(7);
        list.head1.next = new ListNode(5);
        list.head1.next.next = new ListNode(9);
        list.head1.next.next.next = new ListNode(4);
        list.head1.next.next.next.next = new ListNode(6);
        System.out.println("First List is ");
        list.printList(list.head1);

        // creating seconnd list
        list.head2 = new ListNode(8);
        list.head2.next = new ListNode(4);
        System.out.println("Second List is ");
        list.printList(list.head2);

        // add the two lists and see the result
        ListNode rs = list.addTwoNodes(list.head1, list.head2);
        System.out.println("Resultant List is ");
        list.printList(rs);
    }
}


