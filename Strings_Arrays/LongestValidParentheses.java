package Strings_Arrays;

public class LongestValidParentheses {

    public static int longesParenthesis(String str){
        if(str.length() == 0 || str == null) return 0;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                left++;
            }else{
                right++;
            }

            if(left == right){
                max = Math.max(max, 2 * right);
            }else if(left < right){
                right = left = 0;
            }
        }

        left = right = 0;

        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == '('){
                left++;
            }else{
                right--;
            }

            if(left == right){
                max = Math.max(max, 2 * left);
            }
            else if(left > right){
                right = left = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(longesParenthesis((str)));
    }
}
