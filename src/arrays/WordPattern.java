package arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null) {
            return true;
        }
        if(pattern == null || str == null) {
            return false;
        }
        
        char[] pat = pattern.toCharArray();
        String[] tokens = str.split(" ");
        if(tokens.length != pat.length) {
            return false;
        }
        
        HashMap<Character,String> hMap = new HashMap<Character,String>();
        HashSet<String> tokenSet = new HashSet<String>();
        for(int i = 0;i<pat.length;i++) {
            if(hMap.containsKey(pat[i]) && hMap.get(pat[i]).equals(tokens[i])) {
                continue;
            } else if(!hMap.containsKey(pat[i]) && !tokenSet.contains(tokens[i])) {
                hMap.put(pat[i], tokens[i]);
                tokenSet.add(tokens[i]);
            } else {
                return false;
            }           
        }      
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat fish"));

    }

}
