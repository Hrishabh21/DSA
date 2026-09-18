class Solution {
    public String countAndSay(int n) {
        String res = "";
        if(n==1) return "1";
        String s = countAndSay(n-1);
        int cnt = 0;
        for(int i = 0;i<s.length();i++){
            if(i==0){
                cnt++;
                continue;
            }
            if(s.charAt(i)==s.charAt(i-1)){
                cnt++;
            }
            else{
                res+=(String.valueOf(cnt)+s.charAt(i-1));
                cnt = 1;
            }

        }
        res+=(String.valueOf(cnt)+s.charAt(0));


        return res;

        
    }
}