package DynamicProgramming;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;

        int[] dp = new int [amount+1];
        dp[0] = 0; // do not need any coin to get 0 amount
        for(int i = 1; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;

        for(int i = 0; i <= amount; i++){
            for(int coin: coins){
                if(i + coin <= amount){
                    if(dp[i] == Integer.MAX_VALUE){
                        dp[i + coin] = dp[i + coin];
                    }else{
                        dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                    }
                }
            }
        }

        if(dp[amount] >= Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }

    public static int allPossible(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] combos = new int[amount + 1];
        combos[0] = 1;
        for(int coin : coins){
            for(int i = 0; i < combos.length; i++){
                if(i >= coin){
                    combos[i] += combos[i - coin];
                }
            }
        }

        return combos[combos.length - 1] != 0 ? combos[combos.length - 1] : -1;
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 4};
        int amount = 10;
        System.out.println("Minimum number of coins needed to make the amount: " + coinChange(coins, amount));
        System.out.println("Count of all possible combinations of coins to make the sum: " + allPossible(coins, amount));
    }
}
