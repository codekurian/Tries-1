import java.util.*;
class Problem2 {

    TrieNode root ;
    int maxLength = 0;
    String result ="";
    class TrieNode{
        TrieNode[] children ;
        boolean isWordEnd ;
        public TrieNode (){
            this.children = new TrieNode[26];
        }
    }
    //TC: O(N*L)+O(N*L) = O(N*L)
    //SC : O(N*L) + O(L)(stackspace for recusriosn)
    public String longestWord(String[] words) {
        this.root = new TrieNode();
        //TC:O(N*L)
        for(String word : words){
            addWordToDictionary(word);
        }

        StringBuilder path = new StringBuilder();
        //TC:O(N*L)
        //dfsTraverse(this.root,path);
        bfsTraverse();



        return this.result;
    }

    public void addWordToDictionary(String word){
        TrieNode curr = this.root;
        for(char c : word.toCharArray()){
            TrieNode [] children = curr.children;
            if(null == children[c-'a']){
                TrieNode node = new TrieNode ();
                children[c-'a'] = node;
            }
            curr = children[c-'a'];
        }
        curr.isWordEnd = true;

    }

    public void dfsTraverse(TrieNode node,StringBuilder path){
        TrieNode curr = node;
        //base condition
        if(path.length()>this.maxLength){
            //maybe the longest string
            result = path.toString();
            this.maxLength = path.length();
        }

        for(int i=0;i<26;i++) {
            if(curr.children[i]!=null && curr.children[i].isWordEnd){
                path.append((char)(i+'a'));
                dfsTraverse(curr.children[i],path);
                path.deleteCharAt(path.length()-1);
            }

        }


    }


    public void bfsTraverse(){
        Queue<TrieNode> trieQ = new LinkedList<>();
        Queue<String> strQ = new LinkedList<>();
        TrieNode curr = this.root;
        String currStr  = "";
        trieQ.add(curr);
        strQ.add(currStr);

        while(!trieQ.isEmpty()){
            curr =  trieQ.poll();
            currStr = strQ.poll();
            TrieNode[] currChildren = curr.children;
            for(int j=25;j>=0;j--){
                if(currChildren[j] != null && currChildren[j].isWordEnd){
                    trieQ.add(currChildren[j]);
                    strQ.add(currStr+(char)(j+'a'));
                }
            }
        }
        this.result = currStr;


    }


}