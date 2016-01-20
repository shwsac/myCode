package strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> value;
        HashMap<String, List<String>> hMap = new HashMap<String, List<String>>();
        if (strs.length == 0) {
            return null;
        }
        for (String s : strs) {
                    String copy = s;
                    Arrays.sort(copy.toCharArray());
                    if(hMap.containsKey(copy)){
                        value = hMap.get(copy);
                        value.add(s);
                        hMap.put(copy, value);
                    }
                    else {
                        value = new ArrayList<String>();
                        value.add(s);
                        hMap.put(copy, value);
                    }
        }
        for (String key : hMap.keySet()) {
            List<String> ls = new ArrayList<String>();
            ls = hMap.get(key);
            result.add(ls);
        }
        return result;

    }

    
    public static void main(String[] args) {
        String[] str = { "star", "rats", "ice", "cie", "arts", "cat" };
        System.out.println(groupAnagrams(str));

    }

}
