class Solution {
    public int strStr(String txt, String ptrn) {
        int n = txt.length(),m=ptrn.length();
        int[] lps = new int[m];
        int i = 0;
        int j = 1;
        lps[0] = 0;
        while(j<m){
            if(ptrn.charAt(i) == txt.charAt(j)){
                lps[j]=1+lps[j-1];
                i++;
            }
            else{
                lps[j] = 0;
                i =0;
            }
            j++;
        }
        j = 0;
        for(i = 0;i<n;i++){
            if(txt.charAt(i) == ptrn.charAt(j)){
                j++;
            }
            else{
                j = lps[j];
            }
            if(j==m){
                return i-m+1;
            }
        }
        return -1;

        
    }
}