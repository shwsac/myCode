package leetcodepremium;

/*
 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestValue {
    public int closestValue(TreeNode root, double target) {
        
        if(root == null) {
            return 0;
        }
        
        double diff = helper(root, target, Double.MAX_VALUE);
        return (int)(target - diff);
    }
    
    private double helper(TreeNode root, double target, double minDiff) {
        
        if(root == null) {
            return minDiff;
        }
        
        double diff = target - root.val;
       
        if(Math.abs(minDiff) > Math.abs(diff)) {
            minDiff = diff;
        }
        double left = helper(root.left, target, minDiff);
        double right = helper(root.right, target, minDiff);
        if(Math.abs(left) < Math.abs(right)) {
            return left;
        }
        return right;
    }
}
