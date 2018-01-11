package Sorting;

public class InsertionSortApp {
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr = {3,2,7,6,5,4,9,1};
        is.sort(arr);
        System.out.println("Merge Sort: ");
        printArray(arr);
    }
}
