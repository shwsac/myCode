package arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        int p = -1;
        int q = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                p = i - 1;
                break;
            }
        }

        if (p == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int nextGreater = 0;
        for (int i = nums.length - 1; i > p; i--) {
            if (nums[i] > nums[p]) {
                nextGreater = i;
                break;
            }
        }

        System.out.println(nums[p]);
        System.out.println(nums[nextGreater]);

        int temp = nums[p];
        nums[p] = nums[nextGreater];
        nums[nextGreater] = temp;

        if (p < nums.length - 1) {
            reverse(nums, p + 1, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
