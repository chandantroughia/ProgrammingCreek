package Math;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {

    public static List<List<Integer>> getSubsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        backtracking(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){
        result.add(new ArrayList<Integer>(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtracking(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(getSubsets(nums));
    }
}
