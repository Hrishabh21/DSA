class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[] = new int[n];
        dp[0] =1;
    
    //Arrays.fill(dp,1);

    for(int i=1;i<n;i++){
        dp[i] = (obstacleGrid[0][i]^1)&dp[i-1];
        
    }

    for(int i =1;i<m;i++){
        int dp2[] = new int[n];
        dp2[0] =(obstacleGrid[i][0]^1)&dp[0] ;
    for(int j =1;j<n;j++){
        if(obstacleGrid[i][j] == 0)
        dp2[j] = dp[j]+dp2[j-1];
        else
        dp2[j] = 0;
     }
     dp = dp2.clone();
    }
    return dp[n-1];

        
    }
}