package Math;

public class PlusOne {

    public static int[] plusOne(int[] digits){
        if(digits.length == 0 || digits == null) return new int[0];

        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            if(sum >= 10){
                carry = 1;
            }else{
                carry = 0;
            }
            digits[i] = sum % 10;
        }

        if(carry == 0){
            return digits;
        }else{
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for(int i = 1; i < result.length; i++){
                result[i] = digits[i - 1];
            }
            return result;
        }
    }

    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,9};
        int[] result = plusOne(arr);
        printArray(result);
    }
}
