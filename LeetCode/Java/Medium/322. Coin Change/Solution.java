class Solution {
    public int solve(int i,int t,int[] coins){
        if(i==0){
            if(t%coins[i]==0)return t/coins[i];
            else return Integer.MAX_VALUE-1;
        }
        int tk=Integer.MAX_VALUE-1;
        if(t>coins[i])
        tk = 1+solve(i,t-coins[i],coins);
        int nt = solve(i-1,t,coins);
        return Math.min(tk,nt);


    }
    public int coinChange(int[] coins, int V) {
        int n = coins.length;
        
        Arrays.sort(coins);
        int res = solve(n-1,V,coins);
        return res==Integer.MAX_VALUE-1?-1:res;
        
    }
}