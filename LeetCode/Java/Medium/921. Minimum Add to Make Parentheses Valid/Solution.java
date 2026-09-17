class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.add(c);
                continue;
            }
            char b = st.peek();
            if(b=='('&&c==')'){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        return st.size();
        
    }
}