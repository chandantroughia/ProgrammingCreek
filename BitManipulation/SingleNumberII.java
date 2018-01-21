package BitManipulation;

public class SingleNumberII {

    public static int singleNumberII(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            System.out.println("Iteration " + i);
            System.out.println(ones + " ^ " + A[i] + " & " + ~twos + " : "+ ((ones ^ A[i]) & ~twos));
            ones = (ones ^ A[i]) & ~twos;
            System.out.println(twos + " ^ " + A[i] + " & " + ~ones + " : "+ ((twos ^ A[i]) & ~ones));
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 2};
        System.out.println(singleNumberII(arr));
    }
}
