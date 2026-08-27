class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i =1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                dp[i][j] = 1+dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        String res = "";
        int i = n;
        int j = m;
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                res =s1.charAt(i-1)+res;
                i--;
                j--;
            }
            else if(dp[i-1][j]>=dp[i][j-1]){
                 res =s1.charAt(i-1)+res;
                i--;
            }
            else{
                 res =s2.charAt(j-1)+res;
                j--;
            }

        }
        if(i>0){
            res = s1.substring(0,i)+res;
        }
        if(j>0){
            res = s2.substring(0,j)+res;
        }
       return res;
    }
}