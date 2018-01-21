package Strings_Arrays;

public class MaximalSquare {

    public static int maximalSquare(int[][] matrix, int rows, int cols){
        int[][] dp = new int[rows][cols];
        int maxSize  = Integer.MIN_VALUE;

        for(int i = 0; i < rows; i++){
            dp[i][0] = matrix[i][0];
        }

        for(int j = 0; j < cols; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
                    if(dp[i][j] > maxSize){
                        maxSize = dp[i][j];
                    }
                }else{
                    dp[i][j] = matrix[i][j];
                }
            }
        }

        return maxSize;
    }

    private static int min(int x, int y, int z){
        if(x < y) return x < z ? x : z;
        else return y < z ? y : z;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                            {1, 0, 1, 1, 1},
                            {1, 1, 1, 1, 1},
                            {1, 0, 1, 1, 1}};
        System.out.println(maximalSquare(matrix, matrix.length, matrix[0].length));
    }
}
