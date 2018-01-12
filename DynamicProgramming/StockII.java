package DynamicProgramming;

public class StockII {

    public static int maxProfit(int[] nums){
        int profit = 0;
        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i - 1];
            if(diff > 0){
                profit += diff;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 1, 2, 3, 4};
        int[] nums2 = {1,5,4,7};

        System.out.println(maxProfit(nums1));
        System.out.println(maxProfit(nums2));
    }
}
