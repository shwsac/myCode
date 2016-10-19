package leetcodepremium;

/*Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
*/
public class InorderSuccessor {
    // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
    //     if(root == null || p == null) {
    //         return null;
    //     }
        
    //     ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    //     inorder(root,result);
    //     for(int i = 0; i < result.size()-1; i++) {
    //         if(result.get(i) == p) {
    //             return result.get(i+1);
    //         }
    //     }
    //     return null;
    // }
    
    // private void inorder(TreeNode root, ArrayList<TreeNode> result) {
    //     if(root == null) {
    //         return ;
    //     }
        
    //     inorder(root.left, result);
    //     result.add(root);
    //     inorder(root.right, result);
    // }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if(root == null || p == null) {
            return null;
        }
        
        TreeNode current = root;
        TreeNode successor = null;
        
        while(current != null && current.val != p.val) {
            if(current.val < p.val) {
                current = current.right;
            }
            else {
                successor = current;
                current = current.left;
            }
        }
        
        if(current == null) {
            return null;
        }
        
        if(current.right == null) {
            return successor;
        }
        
        current = current.right;
        while(current.left != null) {
            current = current.left;
        }
        return current;
    }
}
