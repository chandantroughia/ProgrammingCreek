package Math;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] arr){
        int temp = 1;

        int[] product = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            product[i] = temp;
            temp = temp * arr[i];
        }

        temp = 1;

        for(int i = arr.length - 1; i >= 0; i--){
            product[i] = product[i] * temp;
            temp = temp * arr[i];
        }

        return product;
    }

    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int[] result = productExceptSelf(arr);
        printArray(result);
        System.out.println(8 | (1 << 3));
    }
}
