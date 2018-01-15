package CombinationsAndPermutaions;

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:[ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

    public static List<List<Integer>> getCombinationSumII(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums,  target, 0);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int remainingTarget, int start){
        if(remainingTarget < 0) return;
        else if(remainingTarget == 0) result.add(new ArrayList<>(temp));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i - 1]) continue;
                temp.add(nums[i]);
                backtracking(result, temp, nums,remainingTarget - nums[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(getCombinationSumII(nums, target));
    }
}
