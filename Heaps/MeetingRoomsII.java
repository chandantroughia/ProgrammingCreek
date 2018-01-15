package Heaps;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals){
        if(intervals.length == 0 || intervals == null) return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval one, Interval two){
                return one.start - two.start;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start >= pq.peek()){
                pq.poll();
                pq.offer(intervals[i].end);
            }else{
                pq.offer(intervals[i].end);
            }
        }

        return pq.size();
    }
}