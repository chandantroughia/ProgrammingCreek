package Sorting;

public class InsertionSort {
    int[] numbers;

    public void sort(int[] values){
        this.numbers = values;
        insertionSort(this.numbers);
    }

    private void insertionSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int j = i;
            while(j > 0 && temp < nums[j - 1]){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
}
