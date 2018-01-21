package Strings_Arrays;

public class PainFence {

    //relation f(n) = (k - 1)(f(n - 1) + f(n - 2));

    public static int numWays(int n, int k){
        int[] dp = {0, k, k * k, 0};
        if(n <= 2) return dp[n];

        for(int i = 2; i < n; i++){
            dp[3] = (k - 1) * (dp[2] + dp[1]);
            dp[1] = dp[2];
            dp[2]=  dp[3];
        }
        return dp[3];
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 4;
        System.out.println(numWays(n, k));
    }
}
