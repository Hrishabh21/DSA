class Solution {
    public int strStr(String txt, String ptrn) {
        int n = txt.length(),m=ptrn.length();
        int[] lps = new int[m];
        int i = 0;
        int j = 1;
        lps[0] = 0;
        while(j<m){
            if(ptrn.charAt(i) == ptrn.charAt(j)){
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
             System.out.println(lps[j-1]+"");
            //j++;
           
        }
        j = 0;
        for(i = 0;i<n;i++){
            if(txt.charAt(i) == ptrn.charAt(j)){
                j++;
            }
            else{
                while(txt.charAt(i) != ptrn.charAt(j)){
                if(j!=0)
                j = lps[j-1];
                else{
                    j=-1;
                    break;
                    }
                }
               
                j++;
            
            }
            if(j==m){
                System.out.println("reached");
                return i-m+1;
            }
        }
        return -1;

        
    }
}