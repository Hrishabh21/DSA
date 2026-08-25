class Solution {
     public int lps(String s) {
        int n = s.length();
        int prev[] = new int[n+1];
        int curr[] = new int[n+1];
        Arrays.fill(prev,0);
        Arrays.fill(curr,0);
        int max = 0;
        for(int i =1;i<=n;i++){
             Arrays.fill(curr,0);
            for(int j =1;j<=n;j++){
                if(s.charAt(i-1) == s.charAt(n-j)){
                    curr[j] = prev[j-1]+1;
                }
                else{
                    curr[j] = Math.max(curr[j-1],prev[j]);
                }
               
            }
            prev = curr.clone();
           
            
        }
        return curr[n];
     }
    public int minInsertions(String s) {
        return s.length()-lps(s);
        
    }
}