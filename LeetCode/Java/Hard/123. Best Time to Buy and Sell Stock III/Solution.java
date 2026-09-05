class Solution {
    public int help(int i,int buy,int[][][] dp,int cap,int[] prices){
        if(i == prices.length||cap == 0) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        if(buy==1){
            return dp[i][buy][cap]=Math.max(-prices[i]+help(i+1,0,dp,cap,prices),help(i+1,buy,dp,cap,prices));
        }
        else{
            return dp[i][buy][cap]=Math.max(prices[i]+help(i+1,1,dp,cap-1,prices),help(i+1,buy,dp,cap,prices));
        }

    }
    public int maxProfit(int[] prices) {
       
        int dp[][][] = new int[prices.length+1][2][3];
        // for(int[][] d:dp){ 
        //     for(int[] c:d){
        //     Arrays.fill(c,-1);
        //     }
        //     }
       // return help(0,1,dp,2,prices);

       for(int i=prices.length-1;i>=0;i--){
        for(int buy = 0;buy<2;buy++){
            for(int cap = 1;cap<3;cap++){
                if(buy==1){
                dp[i][buy][cap]=Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
                }
                else{
                    dp[i][buy][cap]=Math.max(prices[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);
                }

            }
        }
        }
        return dp[0][1][2];
    }
}