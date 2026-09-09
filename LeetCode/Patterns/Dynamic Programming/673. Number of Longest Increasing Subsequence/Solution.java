class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        int cnt[] = new int[n];
        Arrays.fill(cnt,1);
        cnt[0] = 1;
        int lis = 1;
        int ans = 1;
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
            if(nums[j]<nums[i]){
                if(dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    cnt[i] = cnt[j];
                }
                else if(dp[j]+1==dp[i]){
                    cnt[i]+=cnt[j];
                }
            }
            }
            if(lis<dp[i]){
                lis = dp[i];
                ans = cnt[i];
            }
            else if(lis==dp[i]){
                ans+=cnt[i];
            }
        }

        return ans;

    }
}