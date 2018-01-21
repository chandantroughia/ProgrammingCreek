package leetcodeTop100Liked;

public class LongestPalindromicSubstring {

    private static String dpMethod(String str) {
        if(str.length() == 0 || str == null) return null;
        int n = str.length();
        boolean[][] matrix = new boolean[str.length()][str.length()];

        int maxLength = 1;
        for(int i = 0; i < n; i++){
            matrix[i][i] = true;
        }

        int start = 0;
        for(int i = 0; i < n - 1; i++){
            if(str.charAt(i) == str.charAt(i + 1)){
                matrix[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for(int k = 3; k <= n; k++){
            for(int i = 0; i < n - k + 1; i++){
                int j = i + k - 1;

                if(str.charAt(i) == str.charAt(j) && matrix[i + 1][j - 1]){
                    matrix[i][j] = true;
                    if(k > maxLength){
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        return str.substring(start, start + maxLength);
    }

    private static String expandingMethod(String str) {
        if(str.length() == 0 || str == null) return null;
        int start = 0;
        int maxLength = 1;
        int len = str.length();
        int low, high;

        for(int i = 1; i < str.length(); i++){
            low = i - 1;
            high = i;

            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
                if(high - low + 1 > maxLength){
                    maxLength = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }

            low = i - 1;
            high = i + 1;

            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
                if(high - low + 1 > maxLength){
                    maxLength = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
        }

        return str.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String str = "madam";
        System.out.println(dpMethod(str));
        System.out.println(expandingMethod(str));
    }
}
