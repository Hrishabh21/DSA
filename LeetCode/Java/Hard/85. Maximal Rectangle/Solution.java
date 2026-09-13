class Solution {
    public int largestRect(int[] bar){
        int n = bar.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for(int i = 0;i<n;i++){
            while(st.size()>1&&bar[st.peek()]>=bar[i]){
                int temp = bar[st.pop()]*(i - st.peek()-1);
                ans = Math.max(ans,temp);
            }
            st.push(i);
        }
         while(st.size()>1){
                int temp = bar[st.pop()]*(n - st.peek()-1);
                ans = Math.max(ans,temp);
            }
        return ans;

    }
    public int maximalRectangle(char[][] matrix) {
        int [][] bars = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(i==0)
                bars[i][j] = matrix[i][j]-'0';
                else{
                   if(matrix[i][j]=='1'){
                    bars[i][j] = bars[i-1][j]+1;
                   } 
                   else
                    bars[i][j]=0;
                }
            }
            ans = Math.max(ans,largestRect(bars[i]));

        }
        return ans;

        
    }
}