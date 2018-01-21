package Math;

import java.util.HashSet;

public class HappyNumber {

    public static boolean isHappy(int num){
        if(num == 0) return true;
        HashSet<Integer> set = new HashSet<Integer>();

        while(!set.contains(num)){
            set.add(num);

            num = getSum(num);

            if(num == 1){
                return true;
            }
        }
        return false;
    }

    private static int getSum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        int num = 19;
        System.out.println(isHappy(num));
    }
}
