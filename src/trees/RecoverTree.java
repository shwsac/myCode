package trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Result {
    TreeNode first;
    TreeNode second;
    TreeNode third;
    
    Result(TreeNode first,TreeNode second, TreeNode third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Result() {
        first = null;
        second= null;
        third = null;
    }
}
public class RecoverTree {
    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Result result = new Result();;
        Integer min = null;
        Integer max = null;
        recoverTreeHelper(root, min, max,result, root);
        if(result.third !=null) {
            int temp = result.third.val;
            result.third.val = result.first.val;
            result.first.val = temp;
            
        }
        else {
            int temp = result.first.val;
            result.first.val = result.second.val;
            result.second.val = temp;
        }
        displayTree(root);
    }

    public static void recoverTreeHelper(TreeNode root, Integer min, Integer max,Result result,
            TreeNode parent) {
        if (root == null) {
            return;
        }
        if ((min != null && min > root.val) || (max != null && max < root.val)) {
            
            if (result.first == null) {
                result.first = root;
                result.second = parent;           
            }
            else {
                result.third = root;
                if(result.third == result.first.right) {
                    TreeNode temp =result.first;
                    result.first = result.second;
                    result.second = temp;
                }
            }
        }
        recoverTreeHelper(root.left, min, root.val, result, root);
        recoverTreeHelper(root.right, root.val, max, result, root);
    }
    public static void displayTree(TreeNode root) {
        if(root == null) {
            return;
        }
            System.out.println(root.val);
            displayTree(root.left);
            displayTree(root.right);
    }
    public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(3);
      root.right = new TreeNode(1);
      recoverTree(root);
    }

}
