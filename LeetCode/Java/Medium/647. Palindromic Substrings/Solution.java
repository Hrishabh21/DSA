class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int cnt = 0;
        for(int i = n;i>=0;i--){
            for(int j = i;j<n;j++){
               
                    if(s.charAt(i)==s.charAt(j)){
                        if(j-i<2){
                            dp[i][j]=true;
                        }
                        else{
                            dp[i][j]=dp[i+1][j-1];
                        }
                    }
                    if(dp[i][j])cnt++;

                    
                }
                
            }
        return cnt;

        
    }
}