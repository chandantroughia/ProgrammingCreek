package leetcodeTop100Liked;

import java.util.Stack;

class ValidParentheses {

    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        if(str.length() == 0 || str == null) return false;

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
        String str = "()[]{}";
        System.out.println(isValid(str));
    }
}
