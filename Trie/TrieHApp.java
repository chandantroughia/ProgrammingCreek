package Trie;

import java.util.ArrayList;

public class TrieHApp {

    public static void main(String[] args) {
        TrieH a = new TrieH();
        a.insert("there");
        a.insert("their");
        a.insert("then");
        a.insert("them");
        a.insert("therefore");
        //a.insert("their");

        System.out.println(a.isWord("there"));
        System.out.println(a.startsWith("theref"));
        System.out.println(a.isWord("chandan"));
        System.out.println(a.startsWith("abc"));
        ArrayList<String> ans = a.AutoComplete("the");
        System.out.println(ans);
    }
}
