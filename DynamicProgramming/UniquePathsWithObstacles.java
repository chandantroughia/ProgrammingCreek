package DynamicProgramming;

public class UniquePathsWithObstacles {

    public static int getPaths(int[][] board, int row, int col){
        int[][] paths = new int[row + 1][col + 1];
        if(board[0][0] == 0) paths[0][0] = 1;

        //initialize first column
        for(int i = 1; i <= row; i++){
            if(board[i][0] == 0)
                paths[i][0] = paths[i - 1][0];
        }

        //initialize first row
        for(int i = 1; i <= col; i++){
            if(board[0][i] == 0)
                paths[0][i] = paths[0][i - 1];
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(board[i][j] == 0){
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[row][col];
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int row = board.length - 1;
        int col = board[0].length - 1;
        System.out.println(getPaths(board, row, col));
    }
}
