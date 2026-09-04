class Solution {
    public int help(int i,int cs,int[] prices,int n){
        if(i == n) return 0;
        
   
           int buy =help(i+1,prices[i],prices,n);
       
       int sell = 0;
       if(cs!=-1)
        sell =prices[i]-cs+ help(i+1,-1,prices,n);
        
        int notSell = help(i+1,cs,prices,n);
        return Math.max(buy,Math.max(sell,notSell));

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return help(0,-1,prices,n);
        
    }
}