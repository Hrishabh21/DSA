class Solution {
    class DSU{
        private int[] size,parent;
        public DSU(int m){
             size = new int[m];
             parent= new int [m];
             for(int i=0;i<m;i++){
                 parent[i] = i;
             }
             Arrays.fill(size,1);

        }
        public int findParent(int i){
            if(parent[i]==i) return i;
            return  parent[i] = findParent(parent[i]);
        }


        public void unionBySize(int i,int j){
            int ip = findParent(i);
            int jp = findParent(j);
            if(size[ip]<size[jp]){
                parent[ip] = jp;
                size[jp]+=size[ip];
            }
            else{
                parent[jp] = ip;
                size[ip] += size[jp];
            }
        }
    
    }
    public boolean isValid(int r, int c,int m, int n){
        return (r>=0)&&(r<m)&&(c>=0)&&(c<n);
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n*n+1);
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int[] dr ={0,1,-1,0};
                int[] dc = {-1,0,0,1};
                if(grid[i][j] == 1){
                    for(int k=0;k<4;k++){
                        int adr =i+dr[k];
                        int adc =j+dc[k];
                        if(isValid(adr,adc,n,n)){
                             if(grid[adr][adc]==1){
                                int ndno = i*n+j;
                                int adno = adr*n+adc;

                            if(dsu.findParent(ndno)!= dsu.findParent(adno)){
                            
                            dsu.unionBySize(ndno,adno);
                            ans = Math.max(dsu.size[dsu.findParent(ndno)],ans);

                        }
                    }
                        }
                    }
                    if(dsu.size[dsu.findParent(i*n+j)]==1){
                        ans = Math.max(ans,1);
                    }

                }}}


            for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int[] dr ={0,1,-1,0};
                int[] dc = {-1,0,0,1};
                if(grid[i][j] == 0){
                    boolean f = false;
                 for(int k=0;k<4;k++){
                    int adr =i+dr[k];
                    int adc  = j+dc[k];
                    int nd = adr*n+adc;
                    if(isValid(adr,adc,n,n)&&grid[adr][adc]==1){
                        f=true;
                        for(int l =k+1;l<4;l++){
                            int aadr = j+dr[l];
                            int aadc = i+dc[l];
                            int and = aadr*n+aadc;
                            if(isValid(aadr,aadc,n,n)&&grid[aadr][aadc]==1){
                                 if(dsu.findParent(nd)!= dsu.findParent(and)){
                                ans = Math.max(dsu.size[dsu.findParent(nd)]+dsu.size[dsu.findParent(and)]+1,ans);

                            }
                            else{
                                ans = Math.max(dsu.size[dsu.findParent(nd)]+1,ans);
                            }
                            }
                            
                        }
                        
                                ans = Math.max(dsu.size[dsu.findParent(nd)]+1,ans);
                            

            }           
        }
        if(!f) ans = Math.max(ans,1);
        }
        }}
        return ans;

    }
}