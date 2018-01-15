package CombinationsAndPermutaions;
/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is: [ [7], [2, 2, 3] ]
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    public static List<List<Integer>> getCombinationSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int remainingTarget, int start){
        if(remainingTarget < 0) return;
        else if(remainingTarget == 0) result.add(new ArrayList<>(temp));
        else{
            for(int i = start; i < nums.length; i++){
                temp.add(nums[i]);
                backtracking(result, temp, nums, remainingTarget - nums[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(getCombinationSum(nums, target));
    }
}
