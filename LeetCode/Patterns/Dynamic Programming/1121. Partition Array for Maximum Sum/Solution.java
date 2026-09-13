class Solution {
    public int help(int i,int[] arr, int k,int[] dp){
        int n= arr.length;
        if(i>=n) return 0;
        if(dp[i]!=-1)return dp[i];
        int max = arr[i];
        int ans = Integer.MIN_VALUE;
        for(int l = i;(l<n)&&(l<i+k);l++){
            max = Math.max(arr[l],max);
            ans = Math.max(ans,max*(l-(i-1))+help(l+1,arr,k,dp));
        }
        return dp[i] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return help(0,arr,k,dp);

        
    }
}