class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length<n-1) return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] ed:connections){
        adj.get(ed[0]).add(ed[1]);
        adj.get(ed[1]).add(ed[0]);
        }

        int vis[] = new int[n];
        Arrays.fill(vis,0);
        int c = 0;

        for(int i = 0;i<n;i++){
            if(vis[i]==0){
                vis[i] = 1;
                Stack<Integer> st = new Stack<>();
                st.push(i);
                while(!st.isEmpty()){
                    for(int j : adj.get(st.pop())){
                        if(vis[j]==0) st.push(j);
                        vis[j] = 1;
                    }
                }
                c++;

            }
        }
        return c-1;
        
    }
}