class Solution {
    public int rec(int i,int j1,int j2,int m,int n,int grid[][]){
        if(j1<0||j2<0||j1>n-1||j2>n-1){
            return (int)-1e9;
        }
        if(i == m-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        int max = (int)-1e9;
        int curr = (j1==j2)?grid[i][j1]:grid[i][j2]+grid[i][j1];

        for(int k = -1;k<2;k++){
            for(int l = -1;l<2;l++){
                int ans = curr+rec(i+1,j1+k,j2+l,m,n,grid);
                max = Math.max(ans,max);

            }
        }
        return max;
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       int[][][] dp = new int[m][n][n];
      return rec(0,0,n-1,m,n,grid);
        

       
        
    }
}