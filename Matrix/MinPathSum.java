package Matrix;

public class MinPathSum {

    public static int minPathRecur(int[][] cost, int row, int col){
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        else if(row == 0 && col == 0) return cost[row][col];
        else return cost[row][col] + min(minPathRecur(cost, row - 1, col - 1),
                                        minPathRecur(cost, row , col - 1),
                                        minPathRecur(cost, row - 1, col));
    }

    public static int minPathIter(int[][] cost, int row, int col){
        int[][] temp = new int[row + 1][col + 1];
        temp[0][0] = cost[0][0];

        for(int i = 1; i <= row; i++){
            temp[i][0] = cost[i][0] + temp[i - 1][0];
        }

        for(int i = 1; i <= col; i++){
            temp[0][i] = cost[0][i] + temp[0][i - 1];
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                temp[i][j] = cost[i][j] + min(temp[i - 1][j - 1], temp[i - 1][j], temp[i][j - 1]);
            }
        }
        return temp[row][col];
    }

    private static int min(int x, int  y, int z){
        if(x < y){
            return x < z ? x : z;
        }else{
            return y < z ? y : z;
        }
    }

    public static void main(String[] args) {
        int[][] cost = {{1,3,1},
                            {1,5,1},
                            {4,2,1}};

        System.out.println(minPathRecur(cost, cost.length - 1, cost[0].length - 1));
        System.out.println(minPathIter(cost, cost.length - 1, cost[0].length - 1));
    }
}
