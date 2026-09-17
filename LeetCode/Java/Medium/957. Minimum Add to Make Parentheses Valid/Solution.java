class Solution {
    public int minAddToMakeValid(String s) {
        int ob =0;
        int cb = 0;
        int ans = 0;
        
        for(char c : s.toCharArray()){

            if(c=='('){
                ob++;
            }
            else{
                if(ob==0){
                    ans++;
                }
                else
                 ob--;
            }
        }
        return ans+ob;
        
    }
}