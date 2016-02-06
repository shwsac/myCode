package strings;

public class LongestCommonPrefix {


    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length>0){
            result = strs[0];
        }
        for(int i=1; i<strs.length; i++){
            String reference = strs[i];
            int j=0;
            for(; j<Math.min(result.length(), strs[i].length()); j++){
                if(result.charAt(j) != reference.charAt(j)){
                    break;
                }
            }
            result = strs[i].substring(0, j);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] strs = { "a", "a","b" };
        System.out.println(longestCommonPrefix(strs));
    }
}
