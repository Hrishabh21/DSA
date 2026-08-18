class Solution {
    int cnt;
    public void solve(int[] nums,int t,int cs,int i){
        if(i== nums.length){
            if(cs == t)
            cnt++;
            return;
        }
        solve(nums,t,cs+nums[i],i+1);
        solve(nums,t,cs-nums[i],i+1);
        return;

    }


    public int findTargetSumWays(int[] nums, int target) {
        cnt = 0;
        solve(nums,target,0,0);
        return cnt;


        
    }
}