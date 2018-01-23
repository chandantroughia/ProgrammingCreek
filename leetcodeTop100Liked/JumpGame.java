package leetcodeTop100Liked;

public class JumpGame {

    private static boolean canJump(int[] nums){
        if(nums.length <= 1) return true;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(max <= i && nums[i] == 0){
                return false;
            }

            max = Math.max(max, i + nums[i]);
            if(max >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,1,4};
        int[] arr2 = {3,2,1,0,4};
        System.out.println(canJump(arr1));
        System.out.println(canJump(arr2));
    }
}
