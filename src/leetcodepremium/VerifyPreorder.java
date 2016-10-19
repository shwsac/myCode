package leetcodepremium;

import java.util.Stack;

/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
 */
public class VerifyPreorder {
    
    //Space Complexity O(n) , Time O(n)
    
    public boolean verifyPreorder(int[] preorder) {
        
        if(preorder == null || preorder.length == 0) {
            return true;
        }
        
        Stack<Integer> stk = new Stack<Integer>();
        int low =Integer.MIN_VALUE;
        for(int num : preorder) {
            if(num < low) {
                return false;
            }
            
            while(!stk.isEmpty() && num > stk.peek()) {
                low = stk.pop();
            }
            
            stk.push(num);
        }
        return true;
    }

    //Follow up
    //Space O(1), Time O(n)
    public boolean verifyPreorderFU(int[] preorder) {
    
        int low = Integer.MIN_VALUE;
        int index = -1;
        for(int num : preorder) {
            if(num < low) {
                return false;
            }
            
            while(index >=0 && num > preorder[index]) {
                low = preorder[index--];
            }
            
            preorder[++index] = num;
        }
        return true;
    }
   
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
