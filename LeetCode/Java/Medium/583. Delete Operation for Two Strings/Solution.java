class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //int[][] dp = new int[n][m];

        int[] dp1 = new int[m+1];
        Arrays.fill(dp1,0);
        int[] dp2 = new int[m+1];

        for(int i = 1;i<=n;i++){
            Arrays.fill(dp2,0);
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp2[j] = dp1[j-1]+1;
                }
                else{
                    dp2[j] = Math.max(dp2[j-1],dp1[j]);
                }
            }
            dp1 = Arrays.copyOf(dp2,m+1);
        }
        int lcs = dp2[m];
        int ans = n+m-(2*lcs);
        return ans;
    }
}