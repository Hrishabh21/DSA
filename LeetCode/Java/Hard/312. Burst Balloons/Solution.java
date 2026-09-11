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

        
    }
}