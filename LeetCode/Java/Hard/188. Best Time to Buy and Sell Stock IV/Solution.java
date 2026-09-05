class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][] = new int[prices.length+1][2*k+1];
        // for(int[][] d:dp){ 
        //     for(int[] c:d){
        //     Arrays.fill(c,-1);
        //     }
        //     }
       // return help(0,1,dp,2,prices);

       for(int i=prices.length-1;i>=0;i--){
        for(int j = 0;j<2*k;j++){
           
                if(j%2==0){
                dp[i][j]=Math.max(-prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }
                else{
                    dp[i][j]=Math.max(prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }

            
        }
        }
        return dp[0][0];
        
    }
}