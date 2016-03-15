package strings;

public class LongestSubstring {

    public static int getLongestSubstring(String str) {

        if (str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean[] flag = new boolean[256];
        int max_length = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (flag[current]) {
                max_length = Math.max(max_length, i-start);
                for (int k = start; k < i ; k++) {
                    if(chars[k] == current) {
                        start = k+1;
                        break;
                    }
                    flag[chars[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }
        max_length = Math.max(chars.length - start, max_length);
        return max_length;
    }

    public static void main(String[] args) {
      System.out.println(getLongestSubstring("abcabcbb"));
    }

}
