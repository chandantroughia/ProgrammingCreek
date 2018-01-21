package Strings_Arrays;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean validParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '{'){
                stack.push('}');
            }
            else if(c == '['){
                stack.push(']');
            }
            else if(c == '('){
                stack.push(')');
            }
            else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        String t = "{]";

        System.out.println(validParenthesis(s));
        System.out.println(validParenthesis(t));
    }
}
