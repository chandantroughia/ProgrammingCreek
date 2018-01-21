package Math;

public class FactorialTrailingZeors {

    public static int trailingZeors(int number){
        if(number == 0) return -1;
        int count = 0;

        for(int i = 5; number / i >= 1; i *= 5){
            count += number / i;
        }

        return count;
    }

    public static void main(String... args){
        int number = 1000;
        System.out.println(trailingZeors(number));
    }
}
