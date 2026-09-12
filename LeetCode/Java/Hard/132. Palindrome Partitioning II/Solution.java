class Solution {
    public boolean isPalin(String s){
     int n = s.length();
     int i = 0;
     while(i<n/2){
        if(s.charAt(i)!=s.charAt(n-1-i)){
            return false;
        }
        i++;
     }
     return true;
    }
    public int mc(String s,int i,int j){
        if(isPalin(s.substring(i,j))) return 0;
        int c = Integer.MAX_VALUE;
        for(int k =i+1;k<j;k++){
            c =Math.min(c,mc(s,i,k)+mc(s,k,j));
        }
        return c+1;

    }
    public int minCut(String s) {




        
        return mc(s,0,s.length());
    }
}