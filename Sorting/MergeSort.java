package Sorting;

public class MergeSort {
    int[] numbers;
    int[] helper;
    int number;

    public void sort(int[] array){
        this.numbers = array;
        this.number = array.length;
        this.helper = new int[number];
        mergeSort(0, number - 1);
    }

    public void mergeSort(int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public void merge(int low, int mid, int high){
        for(int i = low; i <= high; i++){
            helper[i] = numbers[i];
        }

        int i = low;
        int k = low;
        int j = mid + 1;

        while(i <= mid && j <= high){
            if(helper[i] <= helper[j]){
                numbers[k++] = helper[i++];
            }else{
                numbers[k++] = helper[j++];
            }
        }

        while(i <= mid){
            numbers[k++] = helper[i++];
        }
    }
}
