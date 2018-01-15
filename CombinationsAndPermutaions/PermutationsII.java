package CombinationsAndPermutaions;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations: [ [1,1,2], [1,2,1], [2,1,1] ]
 */
import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

    public static List<List<Integer>> getPermutationsII(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] visited){
        if(nums.length == temp.size()){
            result.add(new ArrayList<>(temp));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                temp.add(nums[i]);
                backtracking(result, temp, nums, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(getPermutationsII(nums));
    }
}
