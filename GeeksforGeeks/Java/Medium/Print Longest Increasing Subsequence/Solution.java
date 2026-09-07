class Solution {
    public ArrayList<Integer> getLIS(int nums[]) {
        // Code here
        
        
        int n = nums.length;

               int[] dp = new int[n];
               int[] hs = new int[n];
               
               for(int i =0;i<n;i++) hs[i] =i;
               
               Arrays.fill(dp,1);

               int ans = 0;
               int j=-1;
               for(int i = 0;i<n;i++){
                   for(int prev = 0;prev<i;prev++){

                     if(nums[i]>nums[prev]){
                         if(dp[i]<dp[prev]+1)
                         hs[i] = prev;
                           dp[i] = Math.max(dp[i],dp[prev]+1);
                       }       

                   }
                   if(dp[i]>ans) j=i;
                   ans = Math.max(dp[i],ans);

               }
               ArrayList<Integer> arr = new ArrayList<>();
               ans--;
               while(ans>=0){
                   arr.add(nums[j]);
                   j = hs[j];
                   ans--;
                   
               }
             

               Collections.reverse(arr);
               return arr;
    }
}
