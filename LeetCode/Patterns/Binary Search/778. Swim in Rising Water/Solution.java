class Solution {
     class Pair{
        int i,j;
        int wt;
        Pair(int i,int j,int w){
            this.wt = w;
            this.i = i;
            this.j = j;
        }
    }
      public boolean isValid(int r, int c,int n) {
    return (r >= 0) && (r < n) && (c >= 0) && (c < n);
  }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
      
        
       int vis[][] = new int[grid.length][grid.length];
        for(int[] v: vis) Arrays.fill(v,0);
       //Arrays.fill(vis,0);
       int res = 0;
       pq.add(new Pair(0,0,gri));
       vis[0][0] = 1;
       while(!pq.isEmpty()){
           
           Pair temp = pq.poll();
          
          int i = temp.i;
          int j = temp.j;
          int t = temp.wt;
          res = Math.max(res,t);
          if(i==grid.length-1&&j == grid.length-1) return res;
            int[] dr = {0, 1, -1, 0};
            int[] dc = {-1, 0, 0, 1};
        
          for (int k = 0; k < 4; k++) {
            int nr = i+dr[k];
            int nc = j+dc[k];
            if(isValid(nr,nc,grid.length)&&vis[nr][nc]!=1){
                pq.add(new Pair(nr,nc,grid[nr][nc]));
                vis[nr][nc] = 1;
            }
          }
       }
       return res;
    }
}