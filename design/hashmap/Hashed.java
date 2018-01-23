package design.hashmap;

import java.util.ArrayList;

public class Hashed<K, V> {

    private static class Node<K, V> {
        public Node<K, V> next;
        public Node<K, V> prev;
        public K key;
        public V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public ArrayList<Node<K, V>> arr;

    public Hashed(int capacity){
        arr = new ArrayList<>();
        arr.ensureCapacity(capacity);
        for(int i = 0; i < capacity; i++){
            arr.add(null);
        }
    }

    public void put(K key, V value){
        Node<K, V> node = getNodeForKey(key);
        if(node != null){
            node.value = value;
        }

        node = new Node<K, V>(key, value);
        int index = getIndexForKey(key);
        if(arr.get(index) != null){
            node.next = arr.get(index);
            node.next.prev = node;
        }

        arr.add(index, node);
    }

    public void remove(K key){
        Node<K, V> node = getNodeForKey(key);
        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }
    }

    public V get(K key){
        Node<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    public Node<K, V> getNodeForKey(K key){
        int index = getIndexForKey(key);
        Node<K, V> current = arr.get(index);
        while(current!= null){
            if(current.key == key){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int getIndexForKey(K key){
        return Math.abs(key.hashCode() % arr.size());
    }
}
