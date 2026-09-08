class Solution {
 
    public int lengthOfLIS(int[] nums) {   
        int n = nums.length;
      
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,1);
         
        int ans = 1;
        for(int i = 1;i<n;i++){
            for(int prev = i-1;prev>=0;prev--){
               
              if(nums[i]>nums[prev]){
                    dp[i] = Math.max(dp[i],dp[prev]+1);
                }       
        
            }
            ans = Math.max(dp[i],ans);

        }

        return ans;
        
    }
}