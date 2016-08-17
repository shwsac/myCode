package trees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();

    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null");
            sb.append(",");
            return;
        }

        sb.append(root.val);
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0) {
            return null;
        }

        String[] chars = data.split(",");
        Deque<String> deque = new LinkedList<String>(Arrays.asList(chars));

        return deserializeHelper(deque);
    }

    private TreeNode deserializeHelper(Deque<String> deque) {
        if (deque.isEmpty()) {
            return null;
        }

        String str = deque.removeFirst();
        if (str.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserializeHelper(deque);
        root.right = deserializeHelper(deque);
        return root;
    }

}
