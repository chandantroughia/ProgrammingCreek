package BitManipulation;

public class MaxBinaryGap {

    public static int getMaxBinaryGap(int number){
        int maxGap = 0;
        int counter = 0;

        while(number != 0){
            int temp = number & 1;
            if(temp == 1){
                maxGap = Math.max(maxGap, counter);
                counter = 0;
            }else{
                counter++;
            }
            number >>= 1;
        }

        return maxGap;
    }

    public static void main(String[] args) {
        int number = 9;
        System.out.println(getMaxBinaryGap(number));
    }
}
