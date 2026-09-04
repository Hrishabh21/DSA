class Solution {
    public int help(int i,int cs,int[] prices,int n,int dp[][]){
        if(i == n) return 0;
        if(dp[i][cs+1]!=-1) return dp[i][cs+1];
        int buy = 0;
        //if dont hold any stock
        if(cs==-1)
        buy =help(i+1,prices[i],prices,n,dp);
       
       int sell = 0;
       //if hold any stock
       if(cs!=-1&&prices[i]>cs)
       sell =prices[i]-cs+ help(i+1,-1,prices,n,dp);

        //skip both buy/sell;
        int skip = help(i+1,cs,prices,n,dp);
        return dp[i][cs+1] =  Math.max(buy,Math.max(sell,skip));

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        for(int p:prices){
            sum+=p;
        }
        int dp[][] = new int[n][sum+2];
        for(int i[]:dp)
        Arrays.fill(i,-1);
        return help(0,-1,prices,n,dp);
        
    }
}