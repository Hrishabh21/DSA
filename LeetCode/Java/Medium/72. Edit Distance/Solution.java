class Solution {
    public int help(int i,int j,String w1,String w2){
        if(i<0&&j<0) return 0;
        //insert 
        if(i<0) return j+1;
        //delete
        if(j<0) return i+1;
        if(w1.charAt(i)==w2.charAt(j)){
            return help(i-1,j-1,w1,w2);
        }
        return Math.min(help(i-1,j,w1,w2), Math.min(help(i-1,j,w1,w2),help(i-1,j-1,w1,w2)))+1;

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();


        return help(n-1,m-1,word1,word2);
        
    }
}