package dynamicprogramming;

public class GuessNumberHIgherLower {
    
    public int getMoneyAmount(int n) {
        
        int[][] DP = new int[n+1][n+1];
        return getMoneyAmountHelper(DP, 1, n);
    }
    
    private int getMoneyAmountHelper (int[][] DP, int low, int high) {
        
        if(low >= high) {
            return 0;
        }
        
        if(DP[low][high] != 0) {
            return DP[low][high];
        }
        int res = Integer.MAX_VALUE;
        for(int i = low; i<= high; i++) {
            int cost = i + Math.max(getMoneyAmountHelper(DP,low,i-1), getMoneyAmountHelper(DP,i+1, high));
            res = Math.min(res,cost);
        }
        
        DP[low][high] = res;
        return res;
    }

}
