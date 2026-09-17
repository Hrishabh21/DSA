class Node{
    private Node[] link;
    Node(){
        link = new Node[2];
    }
    boolean containsKey(int bit){
        return link[bit]!=null;
    }
    Node get(int bit){
        return link[bit];
    }
    void put(int bit,Node n){
        link[bit] = n;
    }

}
class Trie{
    private Node root;
    Trie(){
        root = new Node();
    }
    public void insert(int num){
        Node curr = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(!curr.containsKey(bit))
            curr.put(bit,new Node());
            curr = curr.get(bit);
        }
    }
    public int getMax(int num){
        int res = 0;
        Node curr = root;
        for(int i=31;i>=0;i--){
            if(curr==null) return -1;
            int bit = (num>>i)&1;
            if(curr.containsKey(1-bit)){
                res = res | (1<<i);
                curr = curr.get(1-bit);
            }
            else
                curr = curr.get(bit);
        }
        return res;
    }

}
class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n  = nums.length;
        int q = queries.length;
        int[][] quer = new int[q][3];
        for(int i = 0;i<q;i++){
            quer[i][0]= queries[i][0];
            quer[i][1]= queries[i][1];
            quer[i][2] = i;
        }

        Arrays.sort(quer,(a,b)->a[1]-b[1]);
        int qno = 0;
        int[] ans = new int[q];
        Trie trie = new Trie();
        Arrays.sort(nums);
        for(int i:nums){

            (qno<q&&(i>quer[qno][1])){
                ans[quer[qno][2]] = trie.getMax(quer[qno][0]);
                qno++;
            }
            trie.insert(i);
        }
            while (qno < q) {
        ans[quer[qno][2]] = trie.getMax(quer[qno][0]);
        qno++;
    }
        return ans;
    }
}