class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] nse = new int[n];
        nse[n-1] = n;
        st.push(n-1);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        int ans = 0,pse=-1;
        for(int i = 0;i<n;i++){
             while(!st.isEmpty()&&heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pse = -1;
            }
            else{
                pse = st.peek();
            }
            st.push(i);
            int temp = heights[i]*(nse[i]-pse-1);
            ans = Math.max(temp,ans);
        }
        return ans;


    }

}