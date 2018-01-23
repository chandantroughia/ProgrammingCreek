package leetcodeTop100Liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] strs){
        if(strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> theMap = new HashMap<String, ArrayList<String>>();

        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);

            if(!theMap.containsKey(key)) theMap.put(key,new ArrayList<String>());
            theMap.get(key).add(s);
        }


        return new ArrayList<List<String>>(theMap.values());
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }
}
