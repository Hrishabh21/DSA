class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 0;
        int j = 1;
        lps[0] = 0;
        while(j<n){
            if(s.charAt(i) == s.charAt(j)){
                lps[j]=1+i;
                i++;
                j++;
            }
            else{
               if(i!=0){
                i = lps[i-1];
               }
               else{
                lps[j] = 0;
                j++;
               }
            }
            
           
        }
        return s.substring(0,lps[n-1]);
        
    }
}