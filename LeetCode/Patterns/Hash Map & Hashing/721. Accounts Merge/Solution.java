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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       // List<List<Strings>> res = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        DSU dsu = new DSU(accounts.size());
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(hm.containsKey(accounts.get(i).get(j))){
                    dsu.Union(i,hm.get(accounts.get(i).get(j)));
                }
                else{
                    hm.put(accounts.get(i).get(j),i);
                }
            }
        }
        ArrayList<TreeSet<String>> temp=new ArrayList<>();
        //int j =0;
         for(int i=0;i<accounts.size();i++){
            TreeSet<String> t = new TreeSet<>();
            if(dsu.Find(i)==i){
            t.addAll(accounts.get(i).subList(1,accounts.get(i).size()));
           
            }
            else if({
                temp.get(dsu.Find(i)).addAll(accounts.get(i).subList(1,accounts.get(i).size()));
               
            }
             temp.add(t);

            
         }

         List<List<String>> res = new ArrayList<>();
         int j = 0;
         for(TreeSet t:temp){
            if(!t.isEmpty()){
                res.add(new ArrayList<>());
                res.get(res.size()-1).add(accounts.get(j).get(0));
                res.get(res.size()-1).addAll(t);
            }
            j++;
         }
          return res;

        
        

        
    }
}