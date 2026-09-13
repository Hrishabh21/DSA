class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for(int i = 0;i<n;i++){
            while(st.size()>1&&heights[st.peek()]>=heights[i]){
                int temp = heights[st.pop()]*(i - st.peek()-1);
                ans = Math.max(ans,temp);
            }
            st.push(i);
        }
         while(st.size()>1){
                int temp = heights[st.pop()]*(n - st.peek()-1);
                ans = Math.max(ans,temp);
            }
        return ans;

    }

}