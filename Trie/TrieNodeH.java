package Trie;

import java.util.HashMap;


public class TrieNodeH {

    TrieH root;
    private char character;
    String string; //--> in case autocomplete is needed
    boolean isLast;
    HashMap<Character, TrieNodeH> children = new HashMap<>();

    public TrieNodeH(){} //--> for root

    public TrieNodeH(char c, String s){
        this.character = c;
        this.string = s;
    }
}