package DynamicProgramming;

public class LongestCommonSubstring {

    public static int longesSubstring(String s, String t){
        int[][] matrix = new int[s.length() + 1][t.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
            }
        }

        int maxLength = 0;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(matrix[i][j] > maxLength){
                    maxLength = matrix[i][j];
                    System.out.print(s.charAt(i - 1));
                }
            }
        }
        System.out.println();
        return maxLength;
    }


    public static void main(String[] args) {
        String s = "helloworld";
        String t = "hello";
        int len = longesSubstring(s, t);
        System.out.println(len);
    }
}
