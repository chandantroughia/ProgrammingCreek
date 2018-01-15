package CombinationsAndPermutaions;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {


    public static List<List<Integer>> getSubsetsII(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){
        result.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtracking(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(getSubsetsII(nums));
    }
}
