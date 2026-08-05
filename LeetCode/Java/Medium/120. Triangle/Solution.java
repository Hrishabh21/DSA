class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp1 = new ArrayList<>(triangle.get(0));
        List<Integer> dp2 = new ArrayList<>();
        int n = triangle.size();


        for(int i =1;i<n;i++){
            List<Integer> temp = triangle.get(i);
            int m = temp.size();
            dp2.add(dp1.get(0)+temp.get(0));
            for(int j = 1;j<m;j++){
                if(j<dp1.size())
                dp2.add(Math.min(dp1.get(j),dp1.get(j-1))+temp.get(j));
                else
                dp2.add(dp1.get(j-1)+temp.get(j));
            }
            dp1.clear();
            dp1 = new ArrayList(dp2);
            dp2.clear();
        }
        int res = dp1.get(0);
        for(int i:dp1){
            res = Math.min(i,res);
        }
        return res;



        
    }
}