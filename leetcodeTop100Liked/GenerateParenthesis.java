package leetcodeTop100Liked;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        if(n == 0) return result;
        String str = "";
        recursion(result, str, n, n);
        return result;
    }

    private static void recursion(List<String> result, String str, int left, int right){
        if(left > right) return;
        if(left == 0 && right == 0){
            result.add(str);
            return;
        }

        if(left > 0){
            recursion(result, str + "(", left - 1, right);
        }

        if(right > 0){
            recursion(result, str + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
