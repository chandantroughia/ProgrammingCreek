package Matrix;


/**
 *
 *      [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],  Answer: [1,2,3,6,9,8,7,4,5]
        [ 7, 8, 9 ]
        ]
 *
 */
public class SpiralMatrixI {

    public static void printSpiral(int[][] matrix){
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int dir = 0;

        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    System.out.print(matrix[top][i] + " ");
                }
                top++;
                dir = 1;
            }

            if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    System.out.print(matrix[i][right] + " ");
                }
                right--;
                dir = 2;
            }

            if(dir == 2){
                for(int i = right; i >= left; i--){
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
                dir = 3;
            }

            if(dir == 3){
                for(int i = bottom; i >= top; i--){
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
                dir = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printSpiral(matrix);
    }

}
