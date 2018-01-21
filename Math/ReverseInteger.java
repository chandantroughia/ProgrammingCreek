package Math;

public class ReverseInteger {

    public static int reverseNumber(int num){
        int res = 0;
        while(num != 0){
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 1234;
        System.out.println(reverseNumber(num));
    }
}
