package dynamicprogramming;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;

        }

        int length = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                while (i < nums.length - 2 && nums[i + 1] <= nums[i + 2]) {
                    i++;
                }
                length++;

            }

            else if (nums[i] > nums[i + 1]) {
                while (i < nums.length - 2 && nums[i + 1] >= nums[i + 2]) {
                    i++;
                }
                length++;

            }
        }

        return length;
    }

}
