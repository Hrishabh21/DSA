class Solution {
     private long getAns(long[] arr, int ind, int buy, int n, long[][] dp) {
        // Base case: when we reach the end of the array, no more transactions are possible
        if (ind == n) {
            return 0;
        }

        // If this state is already computed, return it from the DP table
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        long profit;
        if (buy == 0) { 
            // Case when we are allowed to buy
            // Either skip buying (0 + getAns(...)) or buy (-arr[ind] + getAns(...))
            profit = Math.max(
                0 + getAns(arr, ind + 1, 0, n, dp),
                -arr[ind] + getAns(arr, ind + 1, 1, n, dp)
            );
        } else { 
            // Case when we are allowed to sell
            // Either skip selling or sell and add arr[ind] to profit
            profit = Math.max(
                0 + getAns(arr, ind + 1, 1, n, dp),
                arr[ind] + getAns(arr, ind + 1, 0, n, dp)
            );
        }

        // Store result in DP table and return
        dp[ind][buy] = profit;
        return profit;
    }

    public int help(int i,int cs,int[] prices,int n){
        if(i == n) return 0;
      //  if(dp[i][cs+1]!=-1) return dp[i][cs+1];
       
        //if dont hold any stock
        if(cs==-1||prices[i]<cs)
        return help(i+1,prices[i],prices,n);
       
       int sell = 0;
      
       //if hold any stock
       if(cs!=-1&&prices[i]>=cs)
       sell =prices[i]-cs+ help(i+1,prices[i],prices,n);
       
        return sell;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
       
       // int dp[][] = new int[n][sum+2];
        // for(int i[]:dp)
        // Arrays.fill(i,-1);
       // return help(0,-1,prices,n);
       int cs = prices[0];
       int res = 0;
       for(int i =1;i<n;i++){
        if(prices[i]>=prices[i-1]){
            res+=(prices[i]-prices[i-1]);
            
        }
       }

       return res;
        
    }
}