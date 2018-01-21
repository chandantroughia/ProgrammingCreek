package leetcodeTop100Liked;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String str){
        if(str.length() == 0 || str == null) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >= start){
                start = map.get(ch) + 1;
            }
            map.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
