package Math;

public class PowerOfFour {

    public static boolean powerOfFour(int num){
        if(num <= 0) return false;
        while(num % 4 == 0){
            num /= 4;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println(powerOfFour(num));
    }
}
