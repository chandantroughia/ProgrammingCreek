package BitManipulation;

public class SingleNumber {

    public static int getSingleNumber(int[] arr){
        int num = 0;
        for(int i: arr){
            num = num  ^ i;
        }
        return num;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println(getSingleNumber(arr));
    }
}
