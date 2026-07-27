class Solution {
    private List<List<Integer>> res;
    private List<List<Integer>> adj;
    private int[] tin;
    private int[] low;
    private int[] vis;
    private int t = 0;

    public void dfs(int nd,int pr){
        vis[nd] = 1;
        tin[nd] = low[nd] = t;
        t++;
        for(Integer ad:adj.get(nd)){
            if(ad==pr) continue;
            if(vis[ad]!=1){
                dfs(ad,nd);
                low[nd] = Math.min(low[nd],low[ad]);
                if(low[ad]>tin[nd]){
                    res.add(Arrays.asList(ad,nd));
                }
            }
            else{
                 low[nd] = Math.min(low[nd],low[ad]);

               
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        res = new ArrayList<>();
        adj = new ArrayList<>();
        tin = new int[n];
        low = new int[n];
        vis = new int[n];
        Arrays.fill(vis,0);

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(List<Integer> c:connections){
            adj.get(c.get(0)).add(c.get(1));
            adj.get(c.get(1)).add(c.get(0));
            
        }
        dfs(0,-1);
        return res;

        

        
        
    }
}