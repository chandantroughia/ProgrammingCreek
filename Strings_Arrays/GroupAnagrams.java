package Strings_Arrays;


/*
*
*   Given an array of strings, group anagrams together.
*
*   For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
*    Return:
*
*    [
*     ["ate", "eat","tea"],
*     ["nat","tan"],
*     ["bat"]
*   ]
*
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<List<String>>();

        if(arr == null || arr.length == 0);

        for(String s : arr){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        result.addAll(map.values());

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(arr));
    }
}
