class Solution {
    public int help(ArrayList<Integer> arr){
        int ans = 0;
        for(int i = 0;i<arr.size();i++){
            int pc = i==0?1:arr.get(i-1);
            int nc = i==arr.size()-1?1:arr.get(i+1);
            int c = arr.get(i);
            arr.remove(i);
            ans =Math.max(pc*nc*c+help(arr),ans);
            arr.add(i,c);

        }
        return ans;
    }
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i =0;i<n;i++)arr[i+1] = nums[i];
        int[][] dp = new int[n+2][n+2];
        for(int i =n;i>0;i--){
            for(int j = i;j<=n;j++){
                int min = Integer.MIN_VALUE;
       
           for(int k = i;k<=j;k++){
            
               int steps = arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
               min = Math.max(min,steps);
           }
           dp[i][j]=min;
            }
        }
        
        
        return dp[1][n];

        
    }
}