package Strings_Arrays;


        /*
                For example,
                Given s = "the sky is blue",
                return "blue is sky the".
        */

public class ReverseWordsInAString {

    private static void reverseWords(char[] res){
        reverse(res, 0, res.length - 1);
        int k = 0;
        for(int i = 0; i < res.length - 1; i++){
            if(res[i] == ' '){
                reverse(res, k, i - 1);
                k = i + 1;
            }
        }
        reverse(res, k, res.length - 1);
    }

    private static void reverse(char[] res, int start, int end){
        while(start < end) {
            char temp = res[start];
            res[start] = res[end];
            res[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "the sky is blue";
        char[] res = str.trim().replaceAll(" +", " ").toCharArray();;
        System.out.println(String.valueOf(res));
    }
}
