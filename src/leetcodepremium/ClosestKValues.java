package leetcodepremium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */


/*
The time complexity would be O(k + (n - k) logk). 
Space complexity is O(k).
*/
class Wrapper {
    double diff;
    int val;
    
    Wrapper(int val, double diff) {
        this.val = val;
        this.diff = diff;
    }
    
    public double getDiff() {
        return diff;
    }
} 

class MyComp implements Comparator<Wrapper> {
    double target;
    MyComp(double target) {
        this.target = target;
    }
    
    public int compare(Wrapper a, Wrapper b) {
       if(b.getDiff() < a.getDiff()) {
           return -1;
       }
       else if(b.getDiff() > a.getDiff()) {
           return 1;
       }
       return 0;
    }
}
public class ClosestKValues {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        PriorityQueue<Wrapper> queue = new PriorityQueue<Wrapper>(new MyComp(target));
        
        inorderTraversal(root, queue, target,k);
        while(!queue.isEmpty()) {
            Wrapper wrapper = queue.poll();
            result.add(wrapper.val);
        }
        return result;
    }
    
    private void inorderTraversal(TreeNode root, PriorityQueue<Wrapper> queue,double target, int k) {
        
        if(root == null) {
            return;
        }
        
        inorderTraversal(root.left, queue, target, k);
        double diff = Math.abs(target - root.val);
        Wrapper wrapper = new Wrapper(root.val,diff);
        queue.offer(wrapper);
        if(queue.size() > k) {
            queue.poll();
        }
        inorderTraversal(root.right, queue, target, k);
    }
}
