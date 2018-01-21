package Matrix;

public class SpiralMatrixII {

    public static void makeSpiralMatrix(int n){
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int dir = 0;
        int number = 1;
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    matrix[top][i]  = number;
                    number++;
                }
                top++;
                dir = 1;
            }

            if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    matrix[i][right] = number;
                    number++;
                }
                right--;
                dir = 2;
            }

            if(dir == 2){
                for(int i = right; i >= left; i--){
                    matrix[bottom][i] = number;
                    number++;
                }
                bottom--;
                dir = 3;
            }

            if(dir == 3){
                for(int i = bottom; i >= top; i--){
                    matrix[i][left]  = number;
                    number++;
                }
                left++;
                dir = 0;
            }
        }

        printArray(matrix);
    }

    public static void printArray(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        makeSpiralMatrix(n);
    }
}
