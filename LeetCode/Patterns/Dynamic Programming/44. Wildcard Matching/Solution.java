class Solution {
    public boolean help(int i,int j,String s,String p,int[][] dp){
        if(i<0&&j<0) return true;
        if(j<0) return false;
        if(i<0&&p.charAt(j)=='*')
        return help(i,j-1,s,p,dp);
        else if(i<0) return false;
        if(dp[i][j]!=-1) return dp[i][j]==1;

        if(s.charAt(i) == p.charAt(j)||p.charAt(j)=='?'){
        dp[i][j] = help(i-1,j-1,s,p,dp)?1:0;
        
        }
        else if(p.charAt(j)=='*'){
            dp[i][j] = (help(i-1,j,s,p,dp)|help(i,j-1,s,p,dp))?1:0;
            
        }
        else{
            dp[i][j] = 0;
            }
            return dp[i][j]==1;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return help(m-1,n-1,s,p,dp);
        
    }
}