class Solution {
    public boolean isPalin(String s){
     int n = s.length();
     int i = 0;
     while(i<n/2){
        if(s.charAt(i)!=s.charAt(n-1-i)){
            return false;
        }
        i++;
     }
     return true;
    }
    public int mc(String s,int i,int j,int[][] dp){
        if(isPalin(s.substring(i,j))) return dp[i][j]=0;
        if(dp[i][j]!=-1)return dp[i][j];
        int c = Integer.MAX_VALUE;
        for(int k =i+1;k<j;k++){
            c =Math.min(c,mc(s,i,k,dp)+mc(s,k,j,dp));
        }
        return dp[i][j] = c+1;

    }
    public int minCut(String s) {
        int n = s.length();



        int[][] dp = new int[n][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return mc(s,0,s.length(),dp);
    }
}