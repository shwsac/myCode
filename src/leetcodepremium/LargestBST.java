package leetcodepremium;

/*
 Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
 */
class Info {
    int upper = Integer.MIN_VALUE;
    int lower= Integer.MAX_VALUE;
    boolean isBST = false;
    int size = 0;
}

public class LargestBST {

   public int largestBSTSubtree(TreeNode root) {
       
       if(root == null){
           return 0;
       }
       
       return helper(root).size;
   }
   
   private Info helper(TreeNode root) {
       
       Info info = new Info();
       
       if(root == null) {
           info.isBST = true;
           return info;
       }
       
       Info left = helper(root.left);
       Info right = helper(root.right);
       
       info.lower = Math.min(left.lower, root.val);
       info.upper = Math.max(right.upper, root.val);
       
       if(left.isBST && right.isBST && root.val < right.lower && root.val > left.upper) {
           info.isBST = true;
           info.size = left.size + right.size + 1;
       }
       else {
           info.isBST = false;
           info.size = Math.max(left.size, right.size);
       }
       return info;
   }

}
