package dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lookup[] = new int[nums.length];
        Arrays.fill(lookup, -1);
        lookup[0] = nums[0];
        return rob(nums, nums.length - 1, lookup);
    }

    // Top down approach
    private int rob(int[] nums, int n, int[] lookup) {

        if (lookup[n] >= 0) {
            return lookup[n];
        }
        if (n == 0) {
            return nums[0];
        }

        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }

        int amt;
        amt = Math.max(rob(nums, n - 1, lookup), nums[n] + rob(nums, n - 2, lookup));
        lookup[n] = amt;
        return amt;
    }

    // Bottom up approach
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
