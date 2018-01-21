package Math;

public class PowerOfTwo {

    public static boolean powerOfTwo(int num){
        if(num <= 0) return false;
        while(num % 2 == 0){
            num /= 2;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println(powerOfTwo(num));
    }
}
