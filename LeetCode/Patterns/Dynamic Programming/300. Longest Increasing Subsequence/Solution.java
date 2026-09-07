class Solution {
    public int lis(int i,int prev,int[]nums){
        if(i==nums.length) return 0;
        int tk = 0;
        if(nums[i]>prev){
            tk =1+lis(i+1,nums[i],nums);
        }
        return Math.max(tk,lis(i+1,prev,nums));


    }
    public int lengthOfLIS(int[] nums) {    
       return lis(0,Integer.MIN_VALUE,nums);
        
    }
}