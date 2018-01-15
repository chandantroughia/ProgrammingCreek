package Heaps;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsI {
    public boolean canAttendMeetings(Interval[] intervals){
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i].end > intervals[i + 1].start){
                return false;
            }
        }
        return true;
    }
}