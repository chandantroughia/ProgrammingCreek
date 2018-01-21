package Strings_Arrays;


import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    static class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return result;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start){
                    return o1.start - o2.start;
                }else{
                    return o1.end - o2.end;
                }
            }
        });

        Interval pre = intervals.get(0);
        for(int i = 0; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(pre.end >= curr.start){
                Interval merge = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merge;
            }else{
                result.add(pre);
                pre = curr;
            }
        }
        result.add(pre);

        return result;
    }

    public static void printList(List<Interval> result){
        for(Interval i : result){
            System.out.print("[" + i.start + " , " + i.end + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Interval one = new Interval(1, 3);
        Interval two = new Interval(2, 6);
        Interval three = new Interval(8, 10);
        Interval four = new Interval(15, 18);

        List<Interval> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        List<Interval> result = mergeIntervals(list);
        printList(result);
    }
}
