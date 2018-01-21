package BitManipulation;

import java.util.HashMap;

public class TrieNode {

    char c;
    boolean isLast;
    String str;
    HashMap<Character, TrieNode> children = new HashMap<>();

    public TrieNode(){};

    public TrieNode(char c, String str){
        this.c = c;
        this.str = str;
    }
}
