package Math;

public class PowerOfThree {

    public static boolean powerOfThree(int num){
        if(num <= 0) return false;
        while(num % 3 == 0){
            num /= 3;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        int num = 27;
        System.out.println(powerOfThree(num));
    }
}
