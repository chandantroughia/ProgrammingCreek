package Sorting;

public class MergesortApp {
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {3,2,7,6,5,4,9,1};
        ms.sort(arr);
        printArray(arr);
    }
}
