package strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        HashMap<Character,Character> hmap = new HashMap<Character,Character>();
        hmap.put('(', ')');
        hmap.put('[', ']');
        hmap.put('{', '}');
        
        Stack<Character> stck = new Stack<Character>();
        char[] input = s.toCharArray();
        for(int i =0; i<input.length;i++) {
            if(input[i] == '(' || input[i] == '{' || input[i] == '[') {
                stck.push(input[i]);
            }
            else if(hmap.values().contains(input[i])) {
                if(!stck.isEmpty() && hmap.get(stck.peek()) == input[i]) {
                   stck.pop(); 
                } else {
                    return false;
                }   
            }
        }
        return stck.isEmpty();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
