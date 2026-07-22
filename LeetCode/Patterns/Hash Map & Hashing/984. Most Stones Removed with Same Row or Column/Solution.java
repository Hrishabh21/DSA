class Solution {
     class DSU{
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        
        DSU(int n){
            for(int i=0;i<=n;i++){
                rank.add(1);
                parent.add(i);
            }}
        
        public void Union(int x,int y){
            if(rank.get(Find(y))<rank.get(Find(x))){
              parent.set(Find(y),parent.get(Find(x)));
             }
             else{
                
                parent.set(Find(x),parent.get(Find(y)));
                if(rank.get(Find(x))==rank.get(Find(y)))
                rank.set(Find(y),rank.get(Find(y))+1);
           }
        }
         public int Find(int y){
           if(parent.get(y)==y) return y;
           else{
               parent.set(y,Find(parent.get(y)));
               return parent.get(y);
           }
       }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxr=0,maxc=1;
        for(int[] p:stones){
            maxr = Math.max(maxr,p[0]);
            maxc = Math.max(maxc,p[1]);
        }

        DSU ds = new DSU(maxr+maxc+1);

        HashSet<Integer> hs = new HashSet<>();
        for(int[] p:stones){
            ds.Union(p[0],p[1]+maxr+1);
            hs.add(p[0]);
            hs.add(p[1]+maxr+1);
        
        }
        int c = 0;
        for(int i:hs){
            if(ds.Find(i)==i) c++;
        }
        return n-c;
    }
}