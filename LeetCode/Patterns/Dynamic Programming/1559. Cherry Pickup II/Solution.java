class Solution {
    public int rec(int i,int j1,int j2,int m,int n,int dp[][][],int grid[][]){
        if(j1<0||j2<0||j1>n-1||j2>n-1){
            return (int)-1e9;
        }
        if(i == m-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int max = (int)-1e9;
        int curr = (j1==j2)?grid[i][j1]:grid[i][j2]+grid[i][j1];

        for(int k = -1;k<2;k++){
            for(int l = -1;l<2;l++){
                int ans = curr+rec(i+1,j1+k,j2+l,m,n,dp,grid);
                max = Math.max(ans,max);

            }
        }
        return dp[i][j1][j2]= max;
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

    //    for(int[][]a : dp){
    //     for(int[]b:a){
    //         Arrays.fill(b,-1);
    //     }
    //    }

    //   return rec(0,0,n-1,m,n,dp,grid);

    for(int j1 =0;j1<n;j1++){
        for(int j2 =0;j2<n;j2++){
            if(j1 == j2) dp[m-1][j1][j2] = grid[m-1][j1];
            else dp[m-1][j1][j2] = grid[m-1][j1]+grid[m-1][j2];

        }
    }

    for(int i = m-2;i>=0;i--){
        for(int j1 =0;j1<n;j1++){
            for(int j2 =0;j2<n;j2++){
                    int maxi = (int)(-1e9);
                    int curr = (j1 == j2) ? grid[i][j1] 
                                          : grid[i][j1] + grid[i][j2];
                    // Try all 9 moves
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int newJ1 = j1 + dj1;
                            int newJ2 = j2 + dj2;
                            if (newJ1 >= 0 && newJ1 < n &&
                                newJ2 >= 0 && newJ2 < n) {
                                maxi = Math.max(maxi, curr + 
                                       dp[i+1][newJ1][newJ2]);
                            } else {
                                maxi = Math.max(maxi, (int)(-1e9));
                            }
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][n-1];
    }
}