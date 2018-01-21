package BitManipulation;

public class NumberOfSetBits {

    public static int hammingWeight(int number){
        int count = 0;
        while(number != 0){
            count += number & 1;
            number >>= 1;
        }
        return count;
    }

    public static void main(String... args){
        int number = 11;
        System.out.println(hammingWeight(number));
    }
}
