package leetcodepremium;


/*
 Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        
        
        if(root == null) {
            return 0;
        }
        
        return helper(root, root.val - 1, 0);
    }
    
    private int helper(TreeNode root, int prev, int current) {
        if(root == null) {
            return current;
        }
        
        if(root.val- 1 == prev) {
            current++;
            int left = helper(root.left, root.val, current);
            int right = helper(root.right, root.val, current);
            return Math.max(left, right);
        }
        else {
            int left = helper(root.left, root.val, 1);
            int right = helper(root.right, root.val, 1);
            return Math.max(current, Math.max(left, right));
        }
    }
}
