class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[] = new int[n];
        dp[0] =grid[0][0];
       // if(grid[0][0] == 1) return 0;
    
    

        for(int i=1;i<n;i++){
            dp[i] = dp[i-1]+grid[0][i];
            
        }

        for(int i =1;i<m;i++){
            int dp2[] = new int[n];
            dp2[0] =grid[i][0]+dp[0];
        for(int j =1;j<n;j++){
           
            dp2[j] = Math.min(dp[j],dp2[j-1])+grid[i][j];
           
        }
        dp = dp2.clone();
        }
        return dp[n-1];
        
    }
}