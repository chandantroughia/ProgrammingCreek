package leetcodeTop100Liked;

/*
*       Something like this:: (the lists defined below int the main function are different)
*       Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
*       Output: 7 -> 0 -> 8
*       Explanation: 342 + 465 = 807.
*
* */

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}

class List{
    ListNode head1, head2;


    public ListNode addTwoNodes(ListNode one, ListNode two){
        ListNode temp = null;
        ListNode prev = null;
        ListNode result = null;

        int sum = 0;

        while(one != null || two != null){
            sum = sum / 10;

            if(one != null){
                sum += one.val;
                one = one.next;
            }

            if(two != null){
                sum += two.val;
                two = two.next;
            }

            temp = new ListNode(sum % 10);

            if(result == null){
                result = temp;
            }else{
                prev.next = temp;
            }
            prev = temp;
        }

        if(sum / 10 >= 1){
            ListNode newNode = new ListNode(1);
            temp.next = newNode;
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
        // creating first list  ----> head -> 7 -> 5 -> 9 -> 4 -> 6
        list.head1 = new ListNode(7);
        list.head1.next = new ListNode(5);
        list.head1.next.next = new ListNode(9);
        list.head1.next.next.next = new ListNode(4);
        list.head1.next.next.next.next = new ListNode(6);
        System.out.println("First List is ");
        list.printList(list.head1);

        // creating seconnd list ----> head -> 8 -> 4
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
