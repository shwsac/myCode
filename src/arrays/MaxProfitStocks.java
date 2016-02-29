package arrays;

public class MaxProfitStocks {

    public static int maxProfitOneTransaction(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 0;i< prices.length;i++) {
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]- minPrice);
        }
        return maxProfit;
    }
    
    public int maxProfitMultipleTransaction(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int diff = 0;
        int profit = 0;
        for(int i = 1;i < prices.length;i++) {
            diff = prices[i] - prices[i-1];
            if(diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
