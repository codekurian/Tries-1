import java.util.*;
class Trie {
    TrieNode root ;
    class TrieNode{
        TrieNode [] children ;
        boolean isEnd ;

        public TrieNode() {
            children = new TrieNode[26];

        }

    }

    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) { //TC:O(L)
        TrieNode curr = root;
        for(char w : word.toCharArray()){
            if(curr.children[w-'a'] == null){
                TrieNode node = new TrieNode();
                curr.children[w-'a'] = node;
            }
            curr = curr.children[w-'a'];
        }
        curr.isEnd = true;

    }
    //TC:O(L)
    public boolean search(String word) {
        TrieNode curr = root;
        for(char w : word.toCharArray()){
            if(curr.children[w-'a'] == null){
                return false;
            }
            curr = curr.children[w-'a'];
        }
        return curr.isEnd ;
    }
    //TC:O(L)
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char w : prefix.toCharArray()){
            if(curr.children[w-'a'] == null){
                return false;
            }
            curr = curr.children[w-'a'];
        }
        return true ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */