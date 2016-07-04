package trees;

public class IsSymmetric {
    
   public boolean isSymmetric(TreeNode root) {
        
        if(root == null) {
            return true;
        }
        
        return isSymmetricHelper(root,root);
    }
    
    private boolean  isSymmetricHelper(TreeNode left, TreeNode right) {
        
        if(left == null && right == null) {
            return true;
        }
        
        if((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        
        if(left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right)  && isSymmetricHelper(left.right, right.left);
    }

}
