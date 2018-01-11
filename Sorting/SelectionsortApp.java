package Sorting;

public class SelectionsortApp {
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] arr = {3,2,7,6,5,4,9,1};
        ss.sort(arr);
        System.out.println("Selection Sort: ");
        printArray(arr);
    }
}
