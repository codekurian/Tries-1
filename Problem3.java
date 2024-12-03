import java.util.*;
class Problem3 {
    TrieNode root = new TrieNode();
    class TrieNode{
        TrieNode[] children;
        boolean endsWith;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    // TC :O(N*L) + O(M*L)
    // SC :O(N*L) + O(M*L)
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        //TC: O(N*l)
        for(String word :dictionary){//add each word to trie
            addWordToTrie(word);
        }

        //TC :O(M)
        String[] words = sentence.split(" ");

        //TC : O(M)+ O(L)
        for(String word : words){
            result.append(getShortString(word));
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    //TC: O(L)
    public void addWordToTrie(String word){
        TrieNode curr = root;
        for(char w : word.toCharArray()){
            if(curr.children[w-'a'] == null ){
                TrieNode node = new TrieNode();
                curr.children[w-'a'] = node;
            }
            curr = curr.children[w-'a'];
        }
        curr.endsWith = true;
    }

    //TC : O(L)
    public String getShortString(String word){
        StringBuilder shortString = new StringBuilder();
        TrieNode curr = root;
        for(char w : word.toCharArray()){
            if(curr.children[w-'a'] == null || curr.endsWith){
                break;
            }
            curr = curr.children[w-'a'];
            shortString.append(w);


        }
        //if we found the word which is ending we know it is the shorstring in ditionary
        if(curr.endsWith){
            return shortString.toString();
        }
        return word;
    }


}