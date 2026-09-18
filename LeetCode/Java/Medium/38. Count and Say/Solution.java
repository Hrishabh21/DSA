class Solution {
    public String countAndSay(int n) {
        String res = "1";
        if(n==1) return "1";
        for(int i = 2;i<=n;i++){
            String s = res;
            int cnt = 0;
            res = "";
            for(int j = 0;j<s.length();j++){
                if(j==0){
                    cnt++;
                    continue;
                }
                if(s.charAt(j)==s.charAt(j-1)){
                    cnt++;
                }
                else{
                    res+=(String.valueOf(cnt)+s.charAt(j-1));
                    cnt = 1;
                }

            }
            res+=(String.valueOf(cnt)+s.charAt(s.length()-1));
        }
       


        return res;

        
    }
}