class Solution {
    public int helper(int[] cuts,int st,int end,int j,int n){
        if(st>=end) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = st;i<end;i++){
        int cut = (n-j)+helper(cuts,st,i,j,cuts[i])+helper(cuts,i+1,end,cuts[i],n);
        ans = Math.min(ans,cut);

       }
       return ans;
    }
    public int minCost(int n, int[] cuts) {
       
        Arrays.sort(cuts);
       
        return helper(cuts,0,cuts.length,0,n);
        
    }
}