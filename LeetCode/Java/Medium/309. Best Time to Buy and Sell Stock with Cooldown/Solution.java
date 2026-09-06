class Solution {
     public int help(int i,int buy,int[][] dp,int[] prices){
        if(i >= prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i]+help(i+1,0,dp,prices),help(i+1,buy,dp,prices));
        }
        else{
            return dp[i][buy]=Math.max(prices[i]+help(i+2,1,dp,prices),help(i+1,buy,dp,prices));
        }

    }
    public int maxProfit(int[] prices) {
       
        int dp[][] = new int[prices.length][2];
        for(int[] d:dp){
            Arrays.fill(d,-1);
            
            }
        return help(0,1,dp,prices);

   
}}