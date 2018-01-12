package DynamicProgramming;

public class StockI {

    public static int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null) return 0;
        int min = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(min < prices[i]){
                max = Math.max(max, prices[i] - min);
            }else{
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 1, 5, 3, 6, 4};
        int[] nums2 = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(nums1));
        System.out.println(maxProfit(nums2));
    }
}
