class Solution {
    public boolean compare(String w1, String w2){
        if(w1.length()+1!=w2.length())return false;
        int i =0,j =0;
        int f = 1;
        while(i<w1.length()&&j<w2.length()){
            if(w1.charAt(i)==w2.charAt(j))
            {
                i++;
                j++;
            }
            else{
                if(f==0)return false;
                j++;
                f--;
            }
        }
        return true;

    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
      
        Arrays.fill(dp,1);
        int ans = 1;

        Arrays.sort(words,(a,b)->a.length()-b.length());

        for(int i = 1;i<n;i++){
            for(int j =0;j<i;j++){
                if(compare(words[j],words[i])){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        ans = Math.max(ans,dp[i]);
                    }
                }
            }
        }
        return ans;
        
    }
}