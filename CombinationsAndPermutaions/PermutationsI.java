package CombinationsAndPermutaions;

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:[ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */

import java.util.ArrayList;
import java.util.List;

public class PermutationsI {


    public static List<List<Integer>> getPermutationsI(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums);
        return result;
    }

    public static void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backtracking(result, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(getPermutationsI(nums));
    }
}
