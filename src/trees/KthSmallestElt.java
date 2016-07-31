package trees;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

class ResultNew{
    int counter = 0;
    TreeNode node = null;
    ResultNew() {
    }
}
public class KthSmallestElt {

   public static TreeNode kthSmallest(TreeNode root, int k) {
       ResultNew result = new ResultNew();
       kthSmallest(root,k,result);
       return result.node;
   }
   
   public static void kthSmallest(TreeNode root, int k, ResultNew result) {
       if(root == null) {
           return;
       }
       kthSmallest(root.left,k,result);
       result.counter++;
       if(result.counter == k) {
           result.node = root;
       }
       kthSmallest(root.right,k,result);
   }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(17);
        root.right = new TreeNode(24);
        root.left.right = new TreeNode(19);
        root.left.right.left = new TreeNode(18);
        TreeNode result = kthSmallest(root,2);
        System.out.println(result.val);
    }

}
