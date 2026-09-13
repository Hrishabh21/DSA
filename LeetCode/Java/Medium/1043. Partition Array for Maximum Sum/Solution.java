class Solution {
    public int help(int i,int j,int[] arr, int k){
        if(i>j) return 0;
        int max = arr[i];
        int ans = Integer.MIN_VALUE;
        for(int l = i;(l<=j)&&(l<i+k);l++){
            max = Math.max(arr[l],max);
            ans = Math.max(ans,max*(l-(i-1))+help(l+1,j,arr,k));
        }
        return ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        return help(0,n-1,arr,k);

        
    }
}