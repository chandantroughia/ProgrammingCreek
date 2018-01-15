package CombinationsAndPermutaions;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.

        For example,
        If nums = [1,2,3], a solution is:
        [ [3], [1], [2], [1,2,3],[1,3], [2,3], [1,2],[] ]
 */

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {

    public static List<List<Integer>> getSubsetsI(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtracking(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(getSubsetsI(nums));
    }
}
