package Strings_Arrays;

import java.util.Stack;

public class MaximalRectangle {

    public static int maximalRectangle(int[][] matrix, int rows, int cols){
        int[] arr = new int[cols];
        int maxArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0){
                    arr[j] = matrix[i][j];
                }else{
                    arr[j] = arr[j] + matrix[i - 1][j];
                }
            }
            printArr(arr);
            int tempArea = getArea(arr);
            maxArea = Math.max(maxArea, tempArea);
        }
        return maxArea;
    }

    private static void printArr(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int getArea(int[] arr){
        int area_with_top;
        int maxArea = Integer.MIN_VALUE;
        int n = arr.length;
        int i = 0;
        Stack<Integer> s = new Stack<>();

        while(i < n){
            if(s.isEmpty() || arr[i] >= arr[s.peek()]){
                s.push(i++);
            }else{
                int top = s.pop();
                area_with_top = arr[top] * ((s.isEmpty()) ? i : (i - s.peek() - 1));
                maxArea = Math.max(maxArea, area_with_top);
            }
        }

        while(!s.isEmpty()){
            int top = s.pop();
            area_with_top = arr[top] * ((s.isEmpty()) ? i : (i - s.peek() - 1));
            maxArea = Math.max(maxArea, area_with_top);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}};
        System.out.println(maximalRectangle(matrix, matrix.length, matrix[0].length));
    }

}
