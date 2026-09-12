class Solution {
   
    public int mc(String s,int i,int j,int[][] dp,boolean[][] pal){
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(pal[i][j-1]) return dp[i][j]=0;
      
        int ans = Integer.MAX_VALUE;
        for(int k =i+1;k<j;k++){
             if (pal[i][k-1]) {

                // s[i...k] is one palindrome
                // Make one cut after it and solve remaining suffix
                ans = Math.min(
                    ans,
                    1 + mc(s, k,j, dp, pal)
                );
        }
       

        }
         return dp[i][j] = ans;
    }
    public int minCut(String s) {
        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }
        int[][] dp = new int[n][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return mc(s,0,s.length(),dp,pal);
    }
}