package Strings_Arrays;

import java.util.Stack;

public class HistogramArea {

    public static int maxRectangleArea(int[] arr){
        int i = 0;
        int max_area = Integer.MIN_VALUE;
        int area_with_top;
        int n = arr.length;
        Stack<Integer> s = new Stack<>();

        while(i < n){

            if(s.isEmpty() || arr[i] >= arr[s.peek()]){
                s.push(i++);
            }
            else
            {
                int top = s.pop();
                area_with_top = arr[top] * (s.isEmpty() ? i: (i - s.peek() - 1));
                max_area = Math.max(max_area, area_with_top);
            }
        }

        while(!s.isEmpty()){
            int top = s.pop();
            area_with_top = arr[top] * (s.isEmpty() ? i: (i - s.peek() - 1));
            max_area = Math.max(max_area, area_with_top);
        }

        return max_area;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxRectangleArea(arr));
    }
}
