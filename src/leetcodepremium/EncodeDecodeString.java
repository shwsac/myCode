package leetcodepremium;

import java.util.ArrayList;
import java.util.List;

/*
 Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.
 */

public class EncodeDecodeString {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        if(strs == null || strs.size() == 0) {
            return new String("");
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            int len = s == null ? 0:s.length();
            sb.append(len);
            sb.append('#');
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        List<String> result = new ArrayList<String>();
        
        if(s == null || s.length() == 0) {
            return result;
        }
        
        int i = 0;
        while(i < s.length()) {
            int len = 0;
            while(i < s.length() && s.charAt(i) != '#') {
                len = len * 10 + Character.getNumericValue(s.charAt(i));
                i++;
            }
            String str = s.substring(i+1, i + len + 1);
            result.add(str);
            i= i + len + 1;
        }
        return result;
    }
}
