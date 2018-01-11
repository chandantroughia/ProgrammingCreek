package Sorting;

public class QuicksortApp {
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = {3,2,7,6,5,4,9,1};
        qs.sort(arr);
        printArray(arr);
    }
}
