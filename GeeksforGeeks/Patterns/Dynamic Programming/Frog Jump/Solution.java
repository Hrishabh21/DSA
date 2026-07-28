class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if(n==1) return 0;
        
        if(n==2) return Math.abs(height[1] - height[0]);
        
        int[] dp =  new int[n];
        Arrays.fill(dp,-1);
       
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);
        for(int i = 2;i<n;i++){
            dp[i] = Math.min(Math.abs(height[i]-height[i-1])+dp[i-1],Math.abs(height[i]-height[i-2])+dp[i-2]);
            
        }
        return dp[n-1];
        
    }
}