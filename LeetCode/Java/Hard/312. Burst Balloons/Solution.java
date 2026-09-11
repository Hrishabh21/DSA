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
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i:nums) arr.add(i);
        return help(arr);
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i =n-1;i>0;i--){
            for(int j = i+1;j<n;j++){
                int min = Integer.MAX_VALUE;
       
           for(int k = i;k<j;k++){
               int steps = arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
               min = Math.min(min,steps);
           }
           dp[i][j]=min;
            }
        }
        
        
        return dp[1][n-1];

        
    }
}