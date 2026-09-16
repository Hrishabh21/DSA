class Node{
    Node[] link;
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
        for(int i =31;i>=0;i--){
            int bit = (num>>i)&1;
            if(!curr.containsKey(bit)){
               curr.put(bit,new Node());
            }   
            curr = curr.get(bit);  
        }
    }
    public int getMax(int num){
        Node curr = root;
        int maxno = 0;
        for(int i =31;i>=0;i--){
            int bit = (num>>i)&1;
            if(curr.containsKey(1-bit)){
               //curr.set(bit,new Node());
               curr = curr.get(1-bit);
               maxno = maxno | (1<<i);
            }  
            else 
            curr = curr.get(bit);  
        }
        return maxno;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        Trie t = new Trie();
        for(int i:nums){
            t.insert(i);
        }
        for(int i:nums){
           max = Math.max(max,t.getMax(i));
        }
        return max;

        
    }
}