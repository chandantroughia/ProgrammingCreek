package leetcodeTop100Liked;

/*
*
*
* For example, given array S = [-1, 0, 1, 2, -1, -4],  find the combination of three integers that add upto 0.

            A solution set is:
            [
              [-1, 0, 1],
              [-1, -1, 2]
            ]
*
*
* */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        if(arr.length == 0 || arr == null) return result;

        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] > arr[i - 1]) {
                int start = i + 1;
                int end = arr.length - 1;

                while (start < end) {
                    if (arr[i] + arr[start] + arr[end] == 0) {
                        result.add(Arrays.asList(arr[i], arr[start], arr[end]));
                    }

                    if (arr[i] + arr[start] + arr[end] < 0) {
                        int current = start;
                        while (arr[current] == arr[start] && start < end) {
                            start++;
                        }
                    } else {
                        int current = end;
                        while (arr[current] == arr[end] && start < end) {
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}
