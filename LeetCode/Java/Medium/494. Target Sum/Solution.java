class Solution {
    int sum;
    public int solve(int[] nums,int t,int cs,int i,int[][] dp){
        if(i== nums.length){
            if(cs == t)
            return 1;
            return 0;
        }
        int a = cs+nums[i];
        //if(a<0)
        a = a+sum;
        int b = cs-nums[i];
       // if(b<0)
        b = b+sum;
        if(dp[i][a]!=-1) return dp[i][a];
        if(dp[i][b]!=-1) return dp[i][b];


        dp[i][a] = solve(nums,t,cs+nums[i],i+1,dp);
        dp[i][b] = solve(nums,t,cs-nums[i],i+1,dp);
        return dp[i][a]+dp[i][b];

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