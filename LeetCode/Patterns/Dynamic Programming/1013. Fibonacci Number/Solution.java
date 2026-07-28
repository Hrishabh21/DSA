class Solution {
    public int fib(int n) {
        if(n<2) return n;
        int p1 = 0;
        int p2 = 1;
        for(int i=2;i<n+1;i++){
            int t = p2;
            p2 = p2+p1;
            p1 = t;
        }
        return p2;
       
    }
}