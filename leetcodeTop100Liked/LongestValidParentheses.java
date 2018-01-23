package leetcodeTop100Liked;

/*
*
*
* Example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*
*
* */
public class LongestValidParentheses {

    public static int getLongest(String str){
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                left++;
            }else{
                right++;
            }

            if(left == right){
                maxLength = Math.max(maxLength, 2 * right);
            }
            else if(right > left){
                right = left = 0;
            }
        }

        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == '('){
                left++;
            }else{
                right++;
            }

            if(left == right){
                maxLength = Math.max(maxLength, 2 * left);
            }
            else if(right < left){
                right = left = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(getLongest(str));
    }
}
