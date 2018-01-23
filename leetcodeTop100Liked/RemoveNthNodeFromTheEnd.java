//package leetcodeTop100Liked;
//
//
///*
//*
//*  Given linked list: 1->2->3->4->5, and n = 2.
//*
//*  After removing the second node from the end, the linked list becomes 1->2->3->5.
//*
//* */
//
//
//class List{
//
//    ListNode head;
//
//    public ListNode removeNode(ListNode root, int k){
//        ListNode fast = root;
//        ListNode slow = root;
//
//        for(int i = 0; i < k; i++){
//            fast = fast.next;
//        }
//
//        while(fast != null){
//            slow = slow.next;
//            fast = fast.next;
//        }
//
//        slow.val = slow.next.val;
//        slow.next = slow.next.next;
//
//        return root;
//    }
//
//    public void printList(ListNode root){
//        while (root != null){
//            System.out.print(root.val + " ");
//            root = root.next;
//        }
//    }
//
//}
//
//
//public class RemoveNthNodeFromTheEnd {
//
//        public static void main(String[] args) {
//            List list = new List();
//            list.head = new ListNode(1);
//            list.head.next = new ListNode(2);
//            list.head.next.next = new ListNode(3);
//            list.head.next.next.next = new ListNode(4);
//            list.head.next.next.next.next = new ListNode(5);
//
//            int k = 2;
//            ListNode rs = list.removeNode(list.head, k);
//            System.out.println("Resultant List is ");
//            list.printList(rs);
//        }
//
//
//}
