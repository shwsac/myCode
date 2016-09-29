package heap;

import java.util.LinkedList;

public class SlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            
            if (!queue.isEmpty() && queue.peekFirst() == i - k) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }

            queue.offer(i);

            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        int[] sample = new int[] {1,3,-1,-3,5,3,6,7};
        SlidingWindow window = new SlidingWindow();
        int[] result = window.maxSlidingWindow(sample,3);
        for(int i = 0; i< result.length; i++) {
            System.out.print(result[i]);
        }
    }

}
