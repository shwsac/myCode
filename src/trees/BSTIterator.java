package trees;

import java.util.ArrayList;

public class BSTIterator {

    ArrayList<Integer> list = new ArrayList<Integer>();
    int counter = 0;
    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
        populateStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (list.size() == counter) {
            return false;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {

        if (list.size() == counter) {
            return -1;
        }

        int val = list.get(counter);
        counter++;
        return val;
    }

    private void populateStack(TreeNode currNode) {

        if (currNode == null) {
            return;
        }

        populateStack(currNode.left);
        list.add(currNode.val);
        populateStack(currNode.right);
    }

}
