class Solution {
    public int lis(int i,int prev,int[]nums,int[][] dp){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int tk = 0;
        
        if(prev==-1||nums[i]>nums[prev]){
            tk =1+lis(i+1,i,nums,dp);
        }
        
        return dp[i][prev+1]= Math.max(tk,lis(i+1,prev,nums,dp));


    }
    public int lengthOfLIS(int[] nums) {   
        int n = nums.length;
        int[][] dp = new int[nums.length+1][nums.length+1];

        int[] dp1 = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];
         
        // for(int[] d:dp){Arrays.fill(d,-1);}
        // return lis(0,-1,nums,dp);

        for(int i = n-1;i>=0;i--){

            for(int prev = -1;prev<n;prev++){
                int tk = 0;
        
                if(prev==-1||nums[i]>nums[prev]){
                    tk =1+dp1[i+1];
                }       
        
                dp2[prev+1]= Math.max(tk,dp1[prev+1]);

            }
            dp1 = dp2.clone();
        }

        return dp1[0];
        
    }
}