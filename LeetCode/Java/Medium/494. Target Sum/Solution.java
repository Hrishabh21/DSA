class Solution {
    int sum;
    public int solve(int[] nums,int t,int cs,int i,int[][] dp){
        if(i== nums.length){
            if(cs == t)
            return 1;
            return 0;
        }
       int index = cs + sum;

        if (dp[i][index] != -1) {
            return dp[i][index];
        }

        int add = solve(nums, t, cs + nums[i], i + 1, dp);
        int subtract = solve(nums, t, cs - nums[i], i + 1, dp);

        dp[i][index] = add + subtract;

        return dp[i][index];

    }


    public int findTargetSumWays(int[] nums, int target) {
       // cnt = 0;
        sum = 0;
        int n = nums.length;
        for(int i:nums){
            sum+=i;
        }
        
        int dp[][] = new int[n][sum*2 + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
       // if(target<0)
       // target = sum-target;
        return solve(nums,target,0,0,dp);
       // return cnt;


        
    }
}