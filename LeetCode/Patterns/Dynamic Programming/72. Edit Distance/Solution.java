class Solution {
    public int help(int i,int j,String w1,String w2,int[][] dp){
        if(i<0&&j<0) return 0;
        //insert 
        if(i<0) return j+1;
        //delete
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            return dp[i][j] = help(i-1,j-1,w1,w2,dp);
        }
        return dp[i][j]= Math.min(help(i,j-1,w1,w2,dp), Math.min(help(i-1,j,w1,w2,dp),help(i-1,j-1,w1,w2,dp)))+1;

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        // for(int[] d:dp){
        //     Arrays.fill(d,-1);
        // }

        for(int j = 0;j<=m;j++){
            dp[0][j] = j;
        }
         for(int i = 1;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                     }
                else{
                        dp[i][j]= Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]))+1;}

                    }
        }
        return dp[n][m];



        //return help(n-1,m-1,word1,word2,dp);
        
    }
}