class Solution {
    // boolean solve(int[] arr,int i,int t,int[][]dp){
       
    //     if(t == 0) return true;
    //     if(i==0) return arr[i]==t;
    //     if(t<0) return false;
    //     if(dp[i][t]!=-1) return dp[i][t]==1?true:false;
    //     boolean nt = solve(arr,i-1,t,dp);
    //     boolean tk = false;
    //     tk = solve(arr,i-1,t-arr[i],dp);
    //     dp[i][t] = (tk||nt)?1:0;
    //     return tk||nt;
    // }
    public boolean canPartition(int[] arr) {
         int n = arr.length;
         int sum = 0;
         for(int i:arr){
            sum+=i;
         }

        if(sum%2!=0) return false;
        sum/=2;

        boolean[][] dp = new boolean[arr.length][sum+1];
        
        for(int i =0;i<n;i++){
            dp[i][0] =true;
        }
        if(arr[0]<sum)dp[0][arr[0]] =true;
        for(int i =1;i<n;i++){
            for(int t =1;t<=sum;t++){        
                        boolean nt = dp[i-1][t];                
                        boolean tk = false;
                        if(t-arr[i]>=0)
                        tk = dp[i-1][t-arr[i]];
                        dp[i][t] = (tk||nt);            
            }
        }
        return dp[n-1][sum];
        
    }
}