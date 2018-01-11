package Trie;


import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.HashMap;

//TrieNode useing HashMap
public class TrieH {

    private TrieNodeH root;

    public TrieH(){
        root = new TrieNodeH();
    }

    public void insert(String word){
        HashMap<Character, TrieNodeH> children = root.children;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNodeH t;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNodeH(c, word.substring(0, i + 1));
                children.put(c, t);
            }
            children = t.children;

            if(i == word.length() - 1){
                t.isLast = true;
            }
        }
    }

    public boolean isWord(String word){
        TrieNodeH p = getNode(word);
        if(p != null && p.isLast){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix){
        TrieNodeH p = getNode(prefix);
        if(p != null){
            return true;
        }
        return false;
    }

    private TrieNodeH getNode(String word){ //word/prefix
        HashMap<Character, TrieNodeH> children = root.children;
        TrieNodeH t = null;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
        return t;
    }

    public ArrayList<String> AutoComplete(String prefix){
        ArrayList<String> results = new ArrayList<String>();
        TrieNodeH curr = getNode(prefix);
        if(curr != null){
            findAllChildWords(curr, results, prefix);
            return results;
        }
        return results;
    }

    public void findAllChildWords(TrieNodeH curr, ArrayList<String> results, String prefix){
        if(curr.isLast){
            results.add(curr.string);
        }

        for(Character c : curr.children.keySet()){
            findAllChildWords(curr.children.get(c), results, prefix);
        }
    }
}
