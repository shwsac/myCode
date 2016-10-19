package leetcodepremium;

import java.util.ArrayList;
import java.util.List;


/*Given a binary tree, collect a tree's nodes as if you were doing this: 
 * Collect and remove all leaves, repeat until the tree is empty.
 
1
/ \
2   3
/ \     
4   5  


Returns [4, 5, 3], [2], [1].

*/

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class FindLeaves {
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return result;
        }
        
        helper(root,result);
        return result;
    }
    
    public int helper(TreeNode root, List<List<Integer>> result) {
        
        if(root == null) {
            return -1;
        }
        
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        int curr = Math.max(left, right) + 1;
        
        if(result.size() <= curr) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            result.add(temp);
        }
        
        result.get(curr).add(root.val);
        return curr;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
