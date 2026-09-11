class Solution {
    public int helper(int[] cuts,int st,int end,int[][] dp){
        if(st+1==end) return 0;
        if(dp[st][end]!=-1) return dp[st][end];
       
    
        int ans = Integer.MAX_VALUE;
        for(int i = st+1;i<end;i++){
        int cut = (cuts[end]-cuts[st])+helper(cuts,st,i,dp)+helper(cuts,i,end,dp);
        ans = Math.min(ans,cut);

       }
       return dp[st][end] =ans;
    }
    public int minCost(int n, int[] cuts) {
       
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length+2][cuts.length+2];
        for(int[]d:dp)
        Arrays.fill(d,-1);
        int arr[] = new int[cuts.length+2];
        for(int i = 0;i<cuts.length;i++){
            arr[i+1] =cuts[i];
        }
        arr[0] =0;
        arr[cuts.length+1] = n;

       
        return helper(arr,0,cuts.length+1,dp);
        
    }
}