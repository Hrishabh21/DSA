class Solution {

     public int LRA(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] nse = new int[n];
      
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
        int ans = 0,pse;
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

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        Arrays.fill(prev,0);
        int curr[] = new int[m];
       
        int ans = 0;
        for(int i =0;i<n;i++){
             Arrays.fill(curr,0);
            for(int j = 0;j<m;j++){
                if(matrix[i][j]=='1'){
                    curr[j] = 1+prev[j];
                }
                prev[j] = curr[j];

            }
            ans = Math.max(ans,LRA(curr));
           



        }
        return ans;

        
    }
}