class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp1[] = new int [m];
        int dp2[] = new int [m];
        int ans = 0;
        for(int i = 0;i<m;i++){
            dp1[i] = matrix[0][i];
            ans+=dp1[i];
        }
        
        for(int i = 1;i<n;i++){
            dp2[0] = matrix[i][0];
            ans+=dp2[0];
            for(int j = 1;j<m;j++){
                if(matrix[i][j]==1){
                    dp2[j] = Math.min(dp2[j-1],Math.min(dp1[j],dp1[j-1]))+1;
                    ans+=dp2[j];
                }
                else
                dp2[j] = 0;
            }
            dp1 = dp2.clone();
            Arrays.fill(dp2,0);
        }

        return ans;
        
    }
}