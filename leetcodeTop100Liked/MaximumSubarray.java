package leetcodeTop100Liked;

public class MaximumSubarray {

    private static int maxSum(int[] nums){
        int newMax = nums[0];
        int maxSoFar = nums[0];
        for(int i = 1; i < nums.length; i++){
            newMax = Math.max(nums[i], newMax + nums[i]);
            maxSoFar = Math.max(newMax, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(nums));
    }
}
