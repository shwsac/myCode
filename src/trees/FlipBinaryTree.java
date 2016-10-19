package trees;

public class FlipBinaryTree {
    
    public static TreeNode flip(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        return helper(root,root);
    }
    
    private static TreeNode helper(TreeNode root, TreeNode prev) {
        if(root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null){
            return root;
        }
        TreeNode n = helper(root.left,root);
        root.left.left = root.right;
        root.left.right = root;
        root.right = null;
        root.left = null;
        return n;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        inorder(root);
        TreeNode node = flip(root);
        System.out.println();
        inorder(node);
    }
    
    public static void inorder(TreeNode root) {
        
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

}
