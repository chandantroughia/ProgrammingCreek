package leetcodeTop100Liked;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {

    static String[] dialer = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> getCombinations(String str){
        LinkedList<String> result = new LinkedList<String>();

        if(str.length() == 0 || str == null) return result;

        result.add("");

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int index = Character.getNumericValue(ch);
            while(result.peek().length() == i){
                String s = result.poll();
                for(char c : dialer[index].toCharArray()){
                    result.add(s + c);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str  = "23";
        System.out.println(getCombinations(str));
    }
}
