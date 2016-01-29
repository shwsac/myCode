package strings;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(s.length() == 1 || numRows == 1) {
            return s;
        }
        List<List<Character>> lists = new ArrayList<List<Character>>();
        int current = 1;
        boolean increaseflag = true;
        for (int i = 0; i < s.length(); i++) {
            if (current == numRows) {
                increaseflag = false;
            } else if (current == 1) {
                increaseflag = true;
            }
            if (lists.size() < current) {
                ArrayList<Character> list = new ArrayList<Character>();
                lists.add(list);
            }    
            lists.get(current - 1).add(s.charAt(i));
            if (increaseflag) {
                current++;
            } else {
                current--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (List<Character> list : lists) {
            result.append(list.toString().replaceAll("\\[|\\]", "").replaceAll(", ",""));
        }
        return result.toString();
    }

    public static void main(String[] args) {
       System.out.print(convert("AB", 1));
    }
}
