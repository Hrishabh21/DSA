class Solution {
    public int helper(int[] cuts,int st,int end,int j,int n,int[][] dp){
        if(st>=end) return 0;
        if(dp[st][end]!=-1) return dp[st][end];
        int ans = Integer.MAX_VALUE;
        for(int i = st;i<end;i++){
    
        int cut = (n-j)+helper(cuts,st,i,j,cuts[i],dp)+helper(cuts,i+1,end,cuts[i],n,dp);
        ans = Math.min(ans,cut);

       }
       return dp[st][end] =ans;
    }
    public int minCost(int n, int[] cuts) {
       
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length+1][cuts.length+1];
       
        for(int st = cuts.length-1;st>=0;st--){
            int l = st==0?0:cuts[st-1];
            for(int end = st+1;end<=cuts.length;end++){
                int r = end==cuts.length?n:cuts[end];
                int ans = Integer.MAX_VALUE;
                for(int i = st;i<end;i++){
                    
                int cut = (r-l)+dp[st][i]+dp[i+1][end];
                ans = Math.min(ans,cut);
                }
            dp[st][end] =ans;
                    }
        }
       
       
       return dp[0][cuts.length];
        
    }
}