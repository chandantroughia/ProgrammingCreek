package Heaps;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsI {

    static class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendMeetings(Interval[] intervals){
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

    public static void main(String[] args) {
        Interval one = new Interval(1, 3);
        Interval two = new Interval(2, 6);
        Interval three = new Interval(8, 10);
        Interval four = new Interval(15, 18);

        Interval[] intervals = {one, two, three, four};
        System.out.println(canAttendMeetings(intervals));
    }
}
