class Solution {

      public int LRA(int[] bar){
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