package DynamicProgramming;

public class UniquePathsNoObstacles {

    public static int uniquePathRecursive(int row, int col){
        if(row == 1 || col == 1) return 1;
        return uniquePathRecursive(row - 1, col) + uniquePathRecursive(row, col - 1);
    }

    public static int uniquePathDP(int row, int col){
        int[][] temp = new int[row][col];
        //fill first col
        for(int i = 0; i < row; i++){
            temp[i][0] = 1;
        }

        for(int j = 0; j < col; j++){
            temp[0][j] = 1;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }
        return temp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        System.out.println(uniquePathRecursive(row, col));
        System.out.println(uniquePathDP(row, col));
    }
}
