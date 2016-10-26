package leetcodepremium;
/*
 * Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        
        if(s == null || s.length() == 0) {
            return false;
        }
        
        int[] helper = new int[256];
        
        for(int i = 0; i< s.length(); i++) {
            int charIndex = s.charAt(i);
            helper[charIndex]++;
        }
        
        boolean isOdd = false;
        for(int i = 0; i< helper.length; i++) {
            if(helper[i] % 2 != 0) {
                if(isOdd) {
                    return false;
                }
                isOdd = true;
            }
        }
        return true;
    }
}
