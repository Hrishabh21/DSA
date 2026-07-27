class Solution {
    private static HashSet<Integer> res;
    private static List<List<Integer>> adj;
    private static int[] tin;
    private static int[] low;
    private static int[] vis;
    private static int t = 0;

    public static void dfs(int nd,int pr){
        vis[nd] = 1;
        tin[nd] = low[nd] = t;
        t++;
        int child =0;
        for(Integer ad:adj.get(nd)){
            if(ad==pr) continue;
            if(vis[ad]!=1){
                dfs(ad,nd);
                low[nd] = Math.min(low[nd],low[ad]);
                if(low[ad]>=tin[nd]&&pr!=-1){
                    res.add(nd);
                }
                child++;
            }
           else{
                 low[nd] = Math.min(low[nd],tin[ad]);

               
           }
        }
        if(child>1&& pr==-1)
        res.add(nd);
    }
    
    static ArrayList<Integer> articulationPoints(int n, int[][] edges) {
        // code here
        
        res = new HashSet<>();
        adj = new ArrayList<>();
        tin = new int[n];
        low = new int[n];
        vis = new int[n];
        Arrays.fill(vis,0);

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] c:edges){
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
            
        }
        for(int i =0;i<n;i++){
            
        if(vis[i]==0)
        dfs(i,-1);
            
        }
        if(res.isEmpty()) res.add(-1);
        return new ArrayList(res);

        
    }
}