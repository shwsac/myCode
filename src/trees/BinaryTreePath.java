package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> listPath = new ArrayList<String>();
        if (root == null) {
            return listPath;
        }

        ArrayList<String> curr = new ArrayList<String>();
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        binaryTreePaths(results, root, curr);
        for (ArrayList<String> list : results) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                sb.append("->");
                sb.append(list.get(i));
            }
            listPath.add(sb.toString());
        }
        return listPath;
    }

    private void binaryTreePaths(ArrayList<ArrayList<String>> listPath, TreeNode root, ArrayList<String> curr) {
        curr.add(String.valueOf(root.val));

        if (root.left == null && root.right == null) {
            listPath.add(curr);
            return;
        }

        if (root.left != null) {
            ArrayList<String> temp = new ArrayList<String>(curr);
            binaryTreePaths(listPath, root.left, temp);
        }

        if (root.right != null) {
            ArrayList<String> temp = new ArrayList<String>(curr);
            binaryTreePaths(listPath, root.right, temp);
        }
    }

}
