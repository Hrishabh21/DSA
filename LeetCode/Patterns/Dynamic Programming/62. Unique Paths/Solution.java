class Solution {
    // public void travel(int i,int j,int[][] dp, int m, int n){
    //     if((i == m-1&&j == n-1)||i>=m||j>=n) return;
    //     if(j+1<n)
    //     dp[i][j+1] = dp[i][j+1]+dp[i][j];
       
    //     if(i+1<m)
    //     dp[i+1][j] = dp[i+1][j]+dp[i][j];
        
    //     travel(i,j+1,dp,m,n);
    //     travel(i+1,j,dp,m,n);

    // }
    public int uniquePaths(int m, int n) {
    int dp[] = new int[n];
    
    Arrays.fill(dp,1);

    // for(int i=1;i<n+1;i++){
    //  dp[1][i] =1; 
    // }

    for(int i =1;i<m;i++){
        int dp2[] = new int[n];
        dp2[0] = 1;
    for(int j =1;j<n;j++){
        dp2[j] = dp[j]+dp2[j-1];
     }
     dp = dp2.clone();
    }
    return dp[n-1];


      
    }
}