package leetcodeTop100Liked;

public class RotateImage {

    private static void rotate(int[][] matrix){
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - layer - 1;
            for(int i = first; i < last; i++){
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
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
        int[][] matrix = {{5, 1, 9,11},
                          {2, 4, 8,10},
                           {13, 3, 6, 7},
                                {15,14,12,16}};
        printArray(matrix);
        System.out.println();

        rotate(matrix);

        System.out.println();
        printArray(matrix);
    }
}
