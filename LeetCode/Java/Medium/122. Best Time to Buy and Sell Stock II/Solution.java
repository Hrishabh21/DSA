class Solution {
    public int help(int i,int cs,int[] prices,int n){
        if(i == n) return 0;
      //  if(dp[i][cs+1]!=-1) return dp[i][cs+1];
       
        //if dont hold any stock
        if(cs==-1||prices[i]<cs)
        return help(i+1,prices[i],prices,n);
       
       int sell = 0;
      
       //if hold any stock
       if(cs!=-1&&prices[i]>=cs)
       sell =prices[i]-cs+ help(i+1,prices[i],prices,n);
       
        return sell;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        for(int p:prices){
            sum+=p;
        }
       // int dp[][] = new int[n][sum+2];
        // for(int i[]:dp)
        // Arrays.fill(i,-1);
        return help(0,-1,prices,n);
        
    }
}