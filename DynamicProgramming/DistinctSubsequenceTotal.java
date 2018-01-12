package DynamicProgramming;

//Other names: Count distinct occurrences as a subsequence

public class DistinctSubsequenceTotal {

    public static int getDistinctSubsequences(String s, String t){
        int[][] matrix = new int[s.length() + 1][t.length() + 1];

        //fill first column with 1's
        for(int i = 0; i < s.length(); i++){
            matrix[i][0] = 1;
        }

        /*
            Now, if s(0, i) and t(0, j) the elements are equal the matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j],
            else, matrix = matrix[i-1][j]
         */

        for(int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
                }else{
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        return matrix[s.length()][t.length()];
    }


    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        int total = getDistinctSubsequences(s, t);
        System.out.println(total);
    }
}
