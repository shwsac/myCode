package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    
    // O(nlogn) solution
    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // O(k + (n-k)logk)
    public int findKthLargestHeap(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);

        for (int i : nums) {
            queue.offer(i);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

    //O(n) -Best case and O(n^2) worst case
    public int findKthLargestQuickSelect(int[] nums, int k) {

        if (k < 1 || nums == null) {
            return 0;
        }

        return findKthLargest(nums, nums.length - k + 1, 0, nums.length - 1);

    }

    private int findKthLargest(int[] nums, int k, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (left < right && nums[left] < pivot) {
                left++;
            }

            while (right > left && nums[right] >= pivot) {
                right--;
            }

            if (left == right) {
                break;
            }

            int temp;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        int temp;
        temp = nums[left];
        nums[left] = nums[end];
        nums[end] = temp;

        if (k == left + 1) {
            return pivot;
        } else if (k > left + 1) {
            return findKthLargest(nums, k, start + 1, end);
        } else {
            return findKthLargest(nums, k, start, end - 1);
        }
    }
}
