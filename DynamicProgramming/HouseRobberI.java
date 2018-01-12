package DynamicProgramming;

public class HouseRobberI {

    public static int getAmout(int[] nums){
        if(nums.length == 0 || nums == null) return 999999;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int nexToAdj = nums[0];
        int adjacent = Math.max(nums[0], nums[1]);
        int max_loot = 0;
        for(int i = 2; i < nums.length; i++){
            max_loot = Math.max(nexToAdj + nums[i], adjacent);
            nexToAdj = adjacent;
            adjacent = max_loot;
        }
        return max_loot;
    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 1, 3, 8, 2, 4};
        System.out.println(getAmout(nums));
    }
}
