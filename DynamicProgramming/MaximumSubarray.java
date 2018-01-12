package DynamicProgramming;

public class MaximumSubarray {

    public static int maxSubArray(int[] arr){
        int newSum = arr[0];
        int maxSum = arr[0];
        for(int i = 1; i< arr.length; i++){
            newSum = Math.max(newSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, newSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
