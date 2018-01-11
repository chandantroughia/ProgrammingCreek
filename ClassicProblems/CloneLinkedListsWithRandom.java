package ClassicProblems;

import java.util.HashMap;

public class CloneLinkedListsWithRandom {

    class RandomListNode{
        int val;
        RandomListNode next, random;

        public RandomListNode(int val){
            this.val = val;
            this.next = this.random = null;
        }
    }

    public RandomListNode clone(RandomListNode head){
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.val);

        RandomListNode p = head;
        RandomListNode q = newHead;

        map.put(head, newHead);

        p = p.next;
        while(p != null){
            RandomListNode temp = new RandomListNode(p.val);
            map.put(p, temp);
            newHead.next = temp;
            newHead = temp;
            p = p.next;
        }

        p = head;
        q = newHead;

        while(p != null){
            if(p.random != null){
                q.random = map.get(p.random);
            }else{
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}
