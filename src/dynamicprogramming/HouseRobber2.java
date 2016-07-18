package dynamicprogramming;

public class HouseRobber2 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1)
            return nums[0];

        int max1 = robHelper(nums, 0, nums.length - 2);
        int max2 = robHelper(nums, 1, nums.length - 1);

        return Math.max(max1, max2);

    }

    private int robHelper(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        int[] dp = new int[nums.length];
        dp[i] = nums[i];
        dp[i + 1] = Math.max(dp[i], nums[i + 1]);
        for (int k = i + 2; k <= j; k++) {
            dp[k] = Math.max(dp[k - 1], nums[k] + dp[k - 2]);
        }
        return dp[j];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
