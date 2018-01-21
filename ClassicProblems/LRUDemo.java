package ClassicProblems;

public class LRUDemo {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put(1,10);
        cache.put(2,20);
        cache.put(3,30);
        cache.put(4,40);
        cache.put(5,50);
        cache.put(6,60);
        System.out.println(cache.get(1)); // -1
    }

}
