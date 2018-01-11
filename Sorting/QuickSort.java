package Sorting;

public class QuickSort {
    int[] arr;
    int numbers;

    public void sort(int[] values){
        this.arr = values;
        this.numbers = values.length;
        quickSort(0, numbers - 1);
    }

    public void quickSort(int low, int high){
        int i = low;
        int j = high;
        int pivot = arr[low + (high - low)/2];

        while(i <= j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }

            if(i <= j){
                exchange(i++, j--);
            }
        }

        if(i < high){
            quickSort(i, high);
        }
        if(j > low){
            quickSort(low, j);
        }
    }

    public void exchange(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
