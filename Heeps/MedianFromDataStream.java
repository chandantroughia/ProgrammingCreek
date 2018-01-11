package Heeps;

import java.util.Collections;
import java.util.PriorityQueue;


public class MedianFromDataStream {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void pushInHeap(int n){
        if(minHeap.size() == maxHeap.size()){
            if(minHeap.isEmpty() || n < minHeap.peek()){
                maxHeap.offer(n);
            }else{
                maxHeap.offer(minHeap.poll());
                minHeap.offer(n);
            }
        }else{
            if(n > maxHeap.peek()){
                minHeap.offer(n);
            }else{
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(n);
            }
        }
    }

    public static double getMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else{
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            pushInHeap(i);
            System.out.println(getMedian());
        }
        for (int i = 100; i < 150; i += 5) {
            pushInHeap(i);
            System.out.println(getMedian());
        }
    }


}
