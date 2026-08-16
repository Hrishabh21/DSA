class Solution {
    public int solve(int i,int t,int[] coins,int[][] dp){
       // if(t==0) return 0;
        if(i==0){
            if(t%coins[i]==0)return dp[i][t] = t/coins[i];
            else return dp[i][t] = Integer.MAX_VALUE-1;
        }

        if(dp[i][t]!=-1) return dp[i][t];

        int tk=Integer.MAX_VALUE-1;
        if(t>=coins[i])
        tk = 1+solve(i,t-coins[i],coins,dp);
        int nt = solve(i-1,t,coins,dp);
        return dp[i][t]=Math.min(tk,nt);


    }
    public int coinChange(int[] coins, int V) {
        int n = coins.length;
        int[][] dp = new int[n][V+1];

        for(int[] a: dp){
            Arrays.fill(a,-1);
        }

        
        Arrays.sort(coins);
        int res = solve(n-1,V,coins,dp);
        return res==Integer.MAX_VALUE-1?-1:res;
        
    }
}