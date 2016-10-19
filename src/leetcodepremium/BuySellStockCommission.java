package leetcodepremium;

public class BuySellStockCommission {
    
    
    //Commission is flat $10 for each trade
    public static int getMaxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        
        int diff = 0;
        int maxProfit = 0;
        int end = -1;
        for(int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[i-1];
            if(diff > 20 ) {
                maxProfit = maxProfit + diff - 20;
                if(end == i-1) {
                    maxProfit = maxProfit + 20;
                }
                end = i;
            }
        }
        return maxProfit;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //int[] prices = {100, 130, 160, 85, 125};
        int[] prices = {50, 20, 90, 70, 75, 110, 130};
        System.out.println(getMaxProfit(prices));

    }

}
