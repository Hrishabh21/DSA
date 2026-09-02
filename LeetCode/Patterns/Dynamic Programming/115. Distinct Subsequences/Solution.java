class Solution {
    public int help(String s,String t,int i,int j,int[][]dp2){

          if(j==0)return dp[1;
          if(i==0) return 0;
        //  if(i==1&&j==1)return dp2[i][j] =1;
          if(dp2[i][j]!=0) return dp2[i][j];;
         // dp2[i][j] = 1;

            if(s.charAt(i-1)==t.charAt(j-1)){
            
             return dp2[i][j] =help(s,t,i-1,j-1,dp2)+help(s,t,i-1,j,dp2);
            }
           
                else{
                     return dp2[i][j] = help(s,t,i-1,j,dp2);
                }
        
           
          
        }
    
        public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
      
        
        int[][] dp2 = new int[n+1][m+1];
       
        return help(s,t,n,m,dp2);

       
      
        
    }
}