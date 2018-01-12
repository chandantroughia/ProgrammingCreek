package DynamicProgramming;

public class LongestCommonSubsequence {

    public static int getLength(String s, String t){
        int[][] matrix = new int[s.length() + 1][t.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }else{
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
            }
        }
        return matrix[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String S = "ABCDEF";
        String T = "ACBCF";
        int len = getLength(S, T);
        System.out.println(len);
    }
}
