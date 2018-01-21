package Strings_Arrays;

import java.util.Stack;

public class LongestValidParenthesis {

    public static int longestValieParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else{
                if(c == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }
            }
        }
        return Math.abs(stack.size() - str.length());
    }

    public static void main(String[] args) {
        String s = "(()";
        String t = ")()())";

        System.out.println(longestValieParenthesis(s));
        System.out.println(longestValieParenthesis(t));
    }
}
