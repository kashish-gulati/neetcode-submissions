class Solution {
    public int maxProfit(int[] prices) {
        //if inc continue
        //if dec
            //calc profit and comp with max
            //calc new min
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++) {
            profit = Math.max(profit,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        // profit = Math.max(profit,prices[prices.length-1]-min);
        return profit;
    }
}
