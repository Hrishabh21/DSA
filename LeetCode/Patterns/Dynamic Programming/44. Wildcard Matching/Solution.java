class Solution {
    public boolean help(int i,int j,String s,String p){
        if(i<0&&j<0) return true;
        if(j<0) return false;
        if(i<0&&p.charAt(j)=='*')
        return help(i,j-1,s,p);
        else if(i<0) return false;

        if(s.charAt(i) == p.charAt(j)||p.charAt(j)=='?')
        return help(i-1,j-1,s,p);
        if(p.charAt(j)=='*'){
            return help(i-1,j-1,s,p)|help(i-1,j,s,p)|help(i,j-1,s,p);
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        inf
        return help(m-1,n-1,s,p);
        
    }
}