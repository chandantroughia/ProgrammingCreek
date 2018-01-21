package Math;

public class CountPrimes {

    public static int countPrimes(int num){
        if(num <= 2) return 0;

        //init an array to track the primes
        boolean[] prime = new boolean[num];
        for(int i = 2; i < prime.length; i++){
            prime[i] = true;
        }

        for(int i = 2; i < Math.sqrt(num - 1); i++){
            if(prime[i]){
                for(int j = i + i; j < num; j += i){
                    prime[j] = false;
                }
            }
        }

        int count = 0;

        for(int i = 2; i < prime.length; i++){
            if(prime[i]){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int num = 1000;
        System.out.println(countPrimes(num));
    }
}
