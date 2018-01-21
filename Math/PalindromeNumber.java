package Math;

public class PalindromeNumber {

    public static boolean isPlaindrome(int num){
        int result = reverseNumber(num);
        return result == num;
    }

    private static int reverseNumber(int num){
        int res = 0;
        while(num != 0){
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 12321;
        System.out.println(isPlaindrome(num));
    }
}
