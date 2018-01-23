package leetcodeTop100Liked;

public class NextPermutation {

    private static int[] getNextPermutation(int[] arr){
        int i = arr.length - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }

        if(i >= 0){
            int j = arr.length - 1;
            while (j >= 0 && arr[j] <= arr[i]){
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1, arr.length - 1);
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int low, int high){
        while(low < high){
            swap(arr, low++, high--);
        }
    }

    private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,5,8,4,7,6,5,3,1};
        int[] nextPermutation = getNextPermutation(arr);
        printArray(nextPermutation);
    }
}
