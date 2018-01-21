import java.util.ArrayList;

public class Word {

    static ArrayList<String> dict = new ArrayList<>();

    private static void findWord(char[][] board){
        boolean[][] visited = new boolean[board.length][board[0].length];
        String str = "";

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                findWordsUtil(board, visited, i, j, str);
            }
        }
    }

    private static void findWordsUtil(char[][] board, boolean[][] visited, int i, int j, String str){
        visited[i][j] = true;
        str += board[i][j];

        if(dict.contains(str)){
            System.out.println(str);
        }

        for(int row = i - 1; row <= i + 1 && row < board.length; row++){
            for(int col = j - 1; col <= j + 1 && col < board[0].length; col++){
                if (row>=0 && col>=0 && !visited[row][col]){
                    findWordsUtil(board,visited, row, col, str);
                }
            }
        }

        str = str.substring(0, str.length() - 1);
        visited[i][j] = false;
    }

    public static void exist(char[][] board) {

        findWord(board);
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                           {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        dict.add(word);
        exist(board);
    }

}
