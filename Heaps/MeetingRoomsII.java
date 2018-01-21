package Heaps;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    static class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static int getMeetingRoomsRequired(Interval[] intervals){
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(intervals[0].end);
        int count = 1;

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < pq.peek()){
                count++;
            }else{
                pq.poll();
            }
            pq.offer(intervals[i].end);
        }

        return count;
    }

    public static void main(String[] args) {
        Interval one = new Interval(1, 3);
        Interval two = new Interval(2, 6);
        Interval three = new Interval(8, 10);
        Interval four = new Interval(15, 18);
        Interval five = new Interval(19, 22);
        Interval six = new Interval(21, 25);

        Interval[] intervals = {one, two, three, four, five, six};
        System.out.println(getMeetingRoomsRequired(intervals));
    }
}

