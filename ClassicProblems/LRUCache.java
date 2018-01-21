package ClassicProblems;

import java.util.HashMap;

public class LRUCache{
    int capacity;
    Node head;
    Node end;
    HashMap<Integer, Node> map = new HashMap<>();


    class Node{
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    //Constructor for LRUCache
    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    private void remove(Node n){
        if(n.previous != null){
            n.previous.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next != null){
            n.next.previous = n.previous;
        }else{
            end = n.previous;
        }
    }

    private void setHead(Node n){
        n.next = head;
        n.previous = null;

        if(head != null){
            head.previous = n;
        }
        head = n;

        if(end == null){
            end = head;
        }
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size() >= this.capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            }
            else{
                setHead(created);
            }
            map.put(key, created);
        }
    }
}