class Solution {
     public int lb(int st,int end,int num,ArrayList<Integer> arr){

            if(st>=end) return st;
            int m = st+((end-st)/2);


            if(arr.get(m) <num){
                return lb(m+1,end,num,arr);
                }
            else{
                 return lb(st,m,num,arr);
            }

        }
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
         int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        ArrayList<Integer> brr = new ArrayList<>();
        brr.add(nums[n-1]);

        for(int i = 1;i<nums.length;i++){
            if(nums[i]>arr.getLast()){
                arr.add(nums[i]);
            }
            else{
                //lowerbound
                int ind = lb(0,arr.size(),nums[i],arr);
                arr.set(ind,nums[i]);
            }
            
            if(nums[(n-1)-i]>brr.getLast()){
                brr.add(nums[(n-1)-i]);
            }
            else{
                //lowerbound
                int ind = lb(0,brr.size(),nums[(n-1)-i],brr);
                brr.set(ind,nums[(n-1)-i]);
            }
            dp1[i] = arr.size();
            dp2[(n-1)-i] = brr.size();
            
        }
        int ans = 0;
      for(int i =0;i<n;i++){
          if(dp1[i]>1&&dp2[i]>1){
              ans = Math.max(ans,dp1[i]+dp2[i]-1);
          }
      }
      return n-ans;
        
    }
}