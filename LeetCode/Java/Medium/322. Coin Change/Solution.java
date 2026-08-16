class Solution {
    public int coinChange(int[] coins, int V) {
        int n = coins.length;
        int ans=0;
        Arrays.sort(coins);
  for (int i = n - 1; i >= 0; i--) {
    while (V >= coins[i]) {
      V -= coins[i];
      ans++;
    }
    }
    if(V==0)
    return ans;
    else return -1;
        
    }
}