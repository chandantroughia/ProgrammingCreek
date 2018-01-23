package leetcodeTop100Liked;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKSortedLists(ListNode[] lists){
        if(lists.length == 0 || lists == null){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        for(ListNode node : lists){
            if(node != null)
                pq.offer(node);
        }

        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            p.next = n;
            p = p.next;

            if(n.next != null){
                pq.offer(n.next);
            }
        }
        return newHead.next;
    }
}
