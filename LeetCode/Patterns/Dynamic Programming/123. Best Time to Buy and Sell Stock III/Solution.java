class Solution {
    public int help(int i,boolean buy,int cap,int[] prices){
        if(i == prices.length||cap == 0) return 0;
        if(buy){
            return Math.max(-prices[i]+help(i+1,false,cap,prices),help(i+1,buy,cap,prices));
        }
        else{
            return Math.max(prices[i]+help(i+1,true,cap-1,prices),help(i+1,buy,cap,prices));
        }

    }
    public int maxProfit(int[] prices) {
       

       return help(0,true,2,prices);
    }
}