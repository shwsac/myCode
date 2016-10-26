package leetcodepremium;

/*
 There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?

 */
public class PaintHouse2 {
    
    /*
     Time complexity: O(n*k*k).
    Space complexity: O(n*k).
     */
    public int minCostII(int[][] costs) {
        
        if(costs == null || costs.length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        
        for(int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        
        for(int i = 1; i< n; i++) {
            for(int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int m = 0; m< k; m++) {
                    if(m != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][m] + costs[i][j]);
                    }
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            minCost = Math.min(minCost, dp[n-1][i]);
        }
        
        return minCost;
    }
    
    //Follow up
    public int minCostIIFU(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
         
        int n = costs.length;
        int k = costs[0].length;
         
        // dp[j] means the min cost for color j
        int[] dp1 = new int[k];
        int[] dp2 = new int[k];
         
        // Initialization
        for (int i = 0; i < k; i++) {
            dp1[i] = costs[0][i];
        }
         
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp2[j] = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) {
                    if (m != j) {
                        dp2[j] = Math.min(dp1[m] + costs[i][j], dp2[j]);
                    }
                }
            }
             
            for (int j = 0; j < k; j++) {
                dp1[j] = dp2[j];
            }
        }
         
        // Final state
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            minCost = Math.min(minCost, dp1[i]);
        }
         
        return minCost;
    }
}
