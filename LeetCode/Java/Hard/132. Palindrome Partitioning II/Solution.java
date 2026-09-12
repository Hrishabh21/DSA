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
    public int mc(String s,int i,int[] dp){
        if(i==s.length())return 0;
        if(dp[i]!=-1)return dp[i];
        int c = Integer.MAX_VALUE;
        for(int k =i+1;k<=s.length();k++){
            if(isPalin(s.substring(i,k))){
                if (k == s.length()) {
                c = Math.min(c, 0);
            } else {
                c = Math.min(c, 1 + mc(s, k, dp));
            }
            }
         
        }
        return dp[i] = c;

    }
    public int minCut(String s) {
        int n = s.length();



        int[]dp = new int[n];
       
            Arrays.fill(dp,-1);
        
        return mc(s,0,dp);
    }
}