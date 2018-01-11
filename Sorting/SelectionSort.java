package Sorting;

public class SelectionSort {
    int[] numbers;

    public void sort(int[] values){
        this.numbers = values;
        selectionSort(this.numbers);
    }

    private void selectionSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
