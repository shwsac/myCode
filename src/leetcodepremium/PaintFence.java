package leetcodepremium;


/*
 * There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence. 
*/


/*Understand the problem:
We can use a DP solution. 
  -- Define two DP arrays, diff[n] and same[i]. Where diff[i] means the number of ways for the fence i which has different color with fence i -1. same[i] means the number of ways if fence i has the same color with fence i - 1. 
 --  Initialization same[0] = 0, diff[0] = k.
 -- same[i] = diff[i - 1]. 
 -- diff[i] = (k - 1) * (same[i - 1] + diff[i - 1]);

 -- Final state: same[n - 1] + diff[n - 1]. 
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        // i -1 and i -2 with the same color
        int[] dp1 = new int[n];
        // i - 1 and i - 2 with diff. color
        int[] dp2 = new int[n];

        // Initializaiton
        dp1[0] = 0;
        dp2[0] = k;

        for (int i = 1; i < n; i++) {
            dp1[i] = dp2[i - 1];
            dp2[i] = (k - 1) * (dp1[i - 1] + dp2[i - 1]);
        }

        // Final state
        return dp1[n - 1] + dp2[n - 1];
    }

}
