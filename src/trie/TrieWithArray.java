package trie;

//Trie Node
class TrieNodeArray{
  public TrieNodeArray[] children = new TrieNodeArray[26];
  public String item = "";
}

//Trie
class TrieWithArray{
  public TrieNodeArray root = new TrieNodeArray();

  public void insert(String word){
      TrieNodeArray node = root;
      for(char c: word.toCharArray()){
          if(node.children[c-'a']==null){
              node.children[c-'a']= new TrieNodeArray();
          }
          node = node.children[c-'a'];
      }
      node.item = word;
  }

  public boolean search(String word){
      TrieNodeArray node = root;
      for(char c: word.toCharArray()){
          if(node.children[c-'a']==null)
              return false;
          node = node.children[c-'a'];
      }
      if(node.item.equals(word)){
          return true;
      }else{
          return false;
      }
  }

  public boolean startsWith(String prefix){
      TrieNodeArray node = root;
      for(char c: prefix.toCharArray()){
          if(node.children[c-'a']==null)
              return false;
          node = node.children[c-'a'];
      }
      return true;
  }
}
