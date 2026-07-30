class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int m1 = nums[0];
        int m2= Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int temp=m2;
            m2=Math.max(m2,m1+nums[i]);
            m1=temp;
        }
        return m2;
        
    }
}