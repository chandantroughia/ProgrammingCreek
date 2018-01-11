package ClassicProblems;

class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}

public class InteractionsOfTwoLinkedLists {

    Node one, two;

    public int getLen(Node n){
        int count = 0;
        while(n != null){
            count++;
            n = n.next;
        }
        return count;
    }
    public Node getIntersectionNode(Node one, Node two){

        if(one == null || two == null) return null;

        int len1 = getLen(one);
        int len2 = getLen(two);


        Node larger, smaller;
        if(len1 > len2){
            larger = one;
            smaller = two;
        }else{
            larger = two;
            smaller = one;
        }

        int diff = Math.abs(len1 - len2);
        int i = 0;
        while(larger != null && i < diff){
            larger = larger.next;
            i++;
        }

        while(larger != null && smaller != null){
            larger = larger.next;
            smaller = smaller.next;
            if(smaller == larger){
                break;
            }
        }
        return smaller;
    }
}
