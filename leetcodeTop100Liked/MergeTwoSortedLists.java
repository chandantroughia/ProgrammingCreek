package leetcodeTop100Liked;

/*
*
*       Input: 1->2->4, 1->3->4
*       Output: 1->1->2->3->4->4
*
* */

class List{
        ListNode head1, head2;


        public ListNode merge(ListNode one, ListNode two){
            ListNode newHead = new ListNode(0);
            ListNode curr = newHead;

            while(one != null && two != null){
                if(one.val < two.val){
                    curr.next = one;
                    one = one.next;
                }else{
                    curr.next = two;
                    two = two.next;
                }
                curr = curr.next;
            }

            while(one != null){
                curr.next = one;
                one = one.next;
                curr = curr.next;
            }

            while(two != null){
                curr.next = two;
                two = two.next;
                curr = curr.next;
            }

            return newHead.next;

        }

        public void printList(ListNode root){
            while (root != null){
                System.out.print(root.val + " ");
                root = root.next;
            }
        }
    }

    public class MergeTwoSortedLists {

        public static void main(String[] args) {
            List list = new List();
            list.head1 = new ListNode(1);
            list.head1.next = new ListNode(2);
            list.head1.next.next = new ListNode(4);
            System.out.println("First List is ");
            list.printList(list.head1);

            list.head2 = new ListNode(1);
            list.head2.next = new ListNode(3);
            list.head2.next.next = new ListNode(4);
            System.out.println("Second List is ");
            list.printList(list.head2);

            ListNode rs = list.merge(list.head1, list.head2);
            System.out.println("Resultant List is ");
            list.printList(rs);
        }
}
