package DynamicProgramming;

/*
    It's is a recurrsive problem, lets think of it from the end of the digits[]. Initialize the count to 0.
    We deal with two sub problems here:
    1. If the last digit is not zero --> add to count and recurse for previous (n - 1) digits.
    2. If last two digits form a character (ch < 27), we recurse for precious (n - 2) digits and add to the count.
 */
public class DecodeWays {

    public static int decodeWaysRecurssive(char[] digits, int n){
        //base case
        if(n == 0 || n == 1) return 1;
        int count = 0;

        //case 1: digits[n -1] > '0'
        if(digits[n - 1] > '0'){
            count = decodeWaysRecurssive(digits, n - 1);
        }

        //case 2:
        if(digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7')){
            count += decodeWaysRecurssive(digits, n - 2);
        }
        return count;
    }

    public static int decodeWaysDP(char[] digits, int n){

        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 1;

        for(int i = 2; i <= n; i++){
            counts[i] = 0;

            if(digits[i - 1] > '0'){
                counts[i] = counts[i - 1];
            }

            if(digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7')){
                counts[i] += counts[i - 2];
            }
        }
        return counts[n];
    }

    public static void main(String[] args) {
        char[] digits = "1234".toCharArray();
        System.out.println(decodeWaysRecurssive(digits, digits.length));
        System.out.println(decodeWaysDP(digits, digits.length));
    }
}
