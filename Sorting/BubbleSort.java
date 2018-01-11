package Sorting;

public class BubbleSort {
    int[] numbers;

    public void sort(int[] values){
        this.numbers = values;
        bubbelSort(this.numbers);
    }

    private void bubbelSort(int[] numbers){
        for(int i = 0; i < numbers.length ; i++){
            for(int j  = 0; j < numbers.length - i - 1; j++){
                if(numbers[j] > numbers[j + 1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}
