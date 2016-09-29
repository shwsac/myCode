package trie;

import java.util.HashMap;

class TrieNode {

    private HashMap<Character, TrieNode> children;

    private boolean terminates = false;
    private char c;

    // Initialize your data structure here.
    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<Character, TrieNode>();
    }

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }

    public void setTerminates(boolean val) {
        terminates = val;
    }

    public char getChar() {
        return c;
    }

    public boolean isTerminated() {
        return terminates;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

        HashMap<Character, TrieNode> children = root.getChildren();

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.getChildren();

            // set leaf node
            if (i == word.length() - 1)
                t.setTerminates(true);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

        if (word == null || word.length() == 0) {
            return false;
        }

        TrieNode n = searchNode(word);
        if (n != null && n.isTerminated()) {
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

        if (prefix == null || prefix.length() == 0) {
            return false;
        }

        TrieNode n = searchNode(prefix);
        if (n != null) {
            return true;
        }

        return false;
    }

    private TrieNode searchNode(String word) {

        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode n = null;
        for (int i = 0; i < word.length(); i++) {
            n = children.get(word.charAt(i));
            if (n == null) {
                return null;
            }

            children = n.getChildren();
        }
        return n;
    }
}