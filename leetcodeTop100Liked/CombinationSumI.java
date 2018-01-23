package leetcodeTop100Liked;

/*
*
* For example, given candidate set [2, 3, 6, 7] and target 7,
* A solution set is:
* [
* [7],
* [2, 2, 3]
* ]
*
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSumI {

    private static List<List<Integer>> combinationSum(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        backtracking(result, new ArrayList<Integer>(), arr, target, 0);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int remaining, int start){
        if(remaining < 0) return;
        if(remaining == 0){
            result.add(new ArrayList<>(temp));
        }
        else{
            for(int i = start; i < nums.length; i++){
                temp.add(nums[i]);
                backtracking(result, temp, nums, remaining - nums[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }
}
