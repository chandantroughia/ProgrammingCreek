package DynamicProgramming;

public class LongestPalindromicSubstring {

    public static String expandingMethod(String str){
        if(str.length() == 0 || str == null) return str;
        int len = str.length();
        int maxLength = 1;
        int start = 0;
        int low, high;

        for(int i = 1; i < len; i++){
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

        return str.substring(start, maxLength + start);
    }

    public static String dpMethod(String str){
        int n = str.length();
        if(str.length() == 0 || str == null) return str;
        boolean[][] matrix = new boolean[str.length()][str.length()];

        int maxLength = 1;
        for(int i = 0; i < n; i++){
            matrix[i][i] = true;
        }

        int start = 0;
        for(int i = 0; i < n - 1; i++){
            if(str.charAt(i) == str.charAt(i + 1)){
                matrix[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }

        for(int k = 3; k <= n; k++){
            //make the starting point
            for(int i = 0; i < n - k + 1; i++){
                //get the end
                int j = i + k - 1;

                if(matrix[i + 1][j - 1] && str.charAt(i) == str.charAt(j)){
                    matrix[i][j] = true;
                    if(k > maxLength){
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return str.substring(start, maxLength + start);
    }

    public static void main(String[] args) {
        String str = "madam";
        System.out.println(dpMethod(str));
        System.out.println(expandingMethod(str));
    }
}
