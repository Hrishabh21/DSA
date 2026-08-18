class Solution {
   
    public int solve(int[] nums,int t,int cs,int i,int[][] dp){
        if(i== nums.length){
            if(cs == t)
            return 1;
            return 0;
        }
      // int index = cs + sum;

        if (dp[i][cs] != -1) {
            return dp[i][cs];
        }
        int tk = solve(nums, t,cs+nums[i], i + 1, dp);
        int nt = solve(nums, t,cs, i + 1, dp);

        return dp[i][cs] = tk+nt;

    }


    public int findTargetSumWays(int[] nums, int target) {
    
        int sum = 0;
        int n = nums.length;
        for(int i:nums){
            sum+=i;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        if((sum-target)%2!=0) return 0;

        int t = (sum-target)/2;
        int dp[][] = new int[n][sum+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
       
        return solve(nums,t,0,0,dp);
       


        
    }
}