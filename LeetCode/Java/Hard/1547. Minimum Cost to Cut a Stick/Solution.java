class Solution {
    public int helper(int[] cuts,int st,int end,int j,int n,int[][] dp){
        if(st>=end) return 0;
        if(dp[st][end]!=-1) return dp[st][end];
        int ans = Integer.MAX_VALUE;
        for(int i = st;i<end;i++){
       // int cut = (n-j)+helper(cuts,st,i,j,cuts[i])+helper(cuts,i+1,end,cuts[i],n);
        int cut = (n-j)+helper(cuts,st,i,j,cuts[i],dp)+helper(cuts,i+1,end,cuts[i],n,dp);
        ans = Math.min(ans,cut);

       }
       return dp[st][end] =ans;
    }
    public int minCost(int n, int[] cuts) {
       
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length+1][cuts.length+1];
        for(int[]d:dp)
        Arrays.fill(d,-1);
       
        return helper(cuts,0,cuts.length,0,n,dp);
        
    }
}