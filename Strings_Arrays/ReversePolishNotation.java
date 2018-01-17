package Strings_Arrays;


import java.util.Stack;

/*
*
* ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
* ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*
*/
public class ReversePolishNotation {


    private static int evaluateNotation(String[] tokens){
        int result = 0;
        String operators = "+-*/";
        Stack<String> theStack = new Stack<>();

        for(String t: tokens){
            if(!operators.contains(t)){
                theStack.push(t);
            }else{
                int a = Integer.valueOf(theStack.pop());
                int b = Integer.valueOf(theStack.pop());
                int index = operators.indexOf(t);
                switch (index){
                    case 0:
                        theStack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        theStack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        theStack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        theStack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        result = Integer.valueOf(theStack.pop());
        return result;
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};

        System.out.println(evaluateNotation(tokens1));
        System.out.println(evaluateNotation(tokens2));
    }

}
