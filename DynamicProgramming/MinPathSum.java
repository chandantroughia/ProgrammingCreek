package DynamicProgramming;

public class MinPathSum {

    private static int getMin(int x, int y, int z){
        if(x < y) return (x < z) ? x : z;
        else return (y < z) ? y : z;
    }

    public static int getMinPathRecur(int[][] cost, int m, int n){
        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        else if(m == 0 && n == 0) return cost[m][n];
        else return cost[m][n] + getMin(getMinPathRecur(cost, m - 1, n - 1),
                                 getMinPathRecur(cost, m, n - 1 ),
                                 getMinPathRecur(cost, m - 1, n));
    }

    public static int getMinPathDP(int[][] cost, int m, int n){
        int[][] temp = new int[m + 1][n + 1];
        temp[0][0] = cost[0][0];
        //fill the first column
        for(int i = 1; i <= m; i++){
            temp[i][0] = temp[i - 1][0] + cost[i][0];
        }
        //fill the first row
        for(int j = 1; j <= n; j++){
            temp[0][j] = temp[0][j - 1] + cost[0][j];
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                temp[i][j] = cost[i][j] + getMin(temp[i - 1][j], temp[i][j - 1], temp[i - 1][j - 1]);
            }
        }
        return temp[m][n];
    }

    public static void main(String[] args) {
        int[][] cost = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        int m = cost.length - 1;
        int n = cost[0].length - 1;

        System.out.println(getMinPathRecur(cost, m, n));
        System.out.println(getMinPathDP(cost, m, n));
    }
}
