package trees;

public class LCABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        if(p.val < root.val && q.val > root.val) {
            return root;
        }
        if(p.val > root.val && q.val < root.val) {
            return root;
        }
        
        if(root.val > p.val) {
            return lowestCommonAncestor(root.left,p,q);
        } else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
