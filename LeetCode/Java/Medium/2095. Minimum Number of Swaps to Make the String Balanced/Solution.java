class Solution {
    public int minSwaps(String s) {
        int ob =0;
        int cb = 0;
       // int ans = 0;
        
        for(char c : s.toCharArray()){

            if(c=='['){
                ob++;
            }
            else{
                if(ob==0){
                    cb++;
                }
                else
                 ob--;
            }
        }
        return ((cb+1)/2 + (ob+1)/2)/2;
        
    }
}