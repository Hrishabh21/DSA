class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();

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
        j = 0;
        i =0;
        while(i<n){
            if(rev.charAt(i) == s.charAt(j)){
                j++;
                i++;
                //if(j==n) return i-n+1;

               
               
            }
            else{
                
                if(j!=0)
                j = lps[j-1];
                else
                i++;
               
            
            }
           
        }
        System.out.println(j);
        return rev.substring(0,n-j)+s;


    }

}