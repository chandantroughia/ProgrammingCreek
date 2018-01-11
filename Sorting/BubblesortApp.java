package Sorting;

public class BubblesortApp {
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {3,2,7,6,5,4,9,1};
        bs.sort(arr);
        System.out.println("Bubble Sort: ");
        printArray(arr);
    }
}
