class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int m1 = 0;
        int m2 = nums[0];
        for(int i = 1;i<n;i++){
            int t = Math.max(m2,m1+nums[i]);
            m1 = m2;
            m2 = t;
        }
        return m2;
    }
}