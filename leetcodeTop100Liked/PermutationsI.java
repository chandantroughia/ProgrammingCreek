package leetcodeTop100Liked;

import java.util.ArrayList;
import java.util.List;

public class PermutationsI {

    private static List<List<Integer>> getPermutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<Integer>(), nums);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums){
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
        int[] arr = {1, 2, 3};
        System.out.println(getPermutations(arr));
    }
}
