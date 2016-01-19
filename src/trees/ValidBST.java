package trees;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        Integer min = null;
        Integer max = null;
        return isValidBSTHelper(root,min,max);
    }
    
    public boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        
        if(root == null) {
            return true;
        }
        
        if(min !=null && min >= root.val || max !=null && max <= root.val) {
            return false;
        }
        if(!isValidBSTHelper(root.left,min,root.val) || !isValidBSTHelper(root.right,root.val,max)) {
            return false;
        }
        return true;
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
