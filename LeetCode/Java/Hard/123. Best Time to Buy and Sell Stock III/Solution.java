class Solution {
    public int help(int i,int buy,int[][] dp,int cap,int[] prices){
        if(i == prices.length||cap == 0) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i]+help(i+1,0,dp,cap,prices),help(i+1,buy,dp,cap,prices));
        }
        else{
            return dp[i][buy]=Math.max(prices[i]+help(i+1,1,dp,cap-1,prices),help(i+1,buy,dp,cap,prices));
        }

    }
    public int maxProfit(int[] prices) {
       
        int dp[][] = new int[prices.length][2];
        for(int[] d:dp) Arrays.fill(d,-1);
        return help(0,1,dp,2,prices);
    }
}