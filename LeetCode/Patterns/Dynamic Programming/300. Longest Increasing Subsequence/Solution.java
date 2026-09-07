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

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);

        for(int i = 1;i<nums.length;i++){
            if(nums[i]>arr.getLast()){
                arr.add(nums[i]);
            }
            else{
                //lowerbound
                int ind = lb(0,arr.size(),nums[i],arr);
                arr.set(ind,nums[i]);
            }
        }
        return arr.size();

        
    }
}