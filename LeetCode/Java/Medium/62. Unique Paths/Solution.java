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
    int dp[][] = new int[m+1][n+1];
    
   // travel(0,0,dp,m,n);
   for(int i=1;i<n+1;i++){
    dp[1][i] =1; 
   }
   for(int i =2;i<m+1;i++){
    for(int j =1;j<n+1;j++){
        dp[i][j] = dp[i-1][j]+dp[i][j-1];
    }
   }
   return dp[m][n];


      
    }
}