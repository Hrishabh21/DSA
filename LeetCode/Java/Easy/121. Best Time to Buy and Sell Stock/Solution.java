class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mprof = 0;
        int minVal = prices[0];
        for(int i = 1;i<n;i++){
            minVal= Math.min(minVal,prices[i]); 
            mprof= Math.max(prices[i]-minVal,mprof); 
        }

    //     int [] minp = new int [n];
    //   //  minp[0]=prices[0];
    //     int [] maxp = new int [n];
       // maxp[n-1]=prices[n-1];
        // for(int i = 1;i<n;i++){
        //     minp[i] = Math.min(minp[i-1],prices[i]); 
        //     maxp[n-1-i] = Math.max(maxp[n-i],prices[n-1-i]); 
        // }
        // for(int i=0;i<n;i++){
        //     mprof = Math.max(maxp[i]-minp[i],mprof);
        // }
        return mprof;  
    }
}