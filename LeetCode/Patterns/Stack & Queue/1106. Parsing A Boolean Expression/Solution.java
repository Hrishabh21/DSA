class Solution {
    public boolean parseBoolExpr(String exp) {
        Stack<Character> st  = new Stack<>();
       
        int i = 0;
        int n = exp.length();
        while(i<n){
            if(st.isEmpty()){
                st.push(exp.charAt(i));
                i++;
                continue;
            }
            char c = exp.charAt(i);
            if(c ==')'){
                boolean hasTrue = false;
                boolean hasFalse = false;
                while(st.peek()!='('){
                    if(st.pop()=='t')
                    hasTrue = true;
                    else
                    hasFalse = true;    

                }
                st.pop();
                char ex = st.pop();
                if(ex =='&'){
                    st.push(hasFalse?'f':'t');
                }
                else if(ex=='|'){
                    st.push(hasTrue?'t':'f');
                }
                else{
                    st.push(hasFalse?'t':'f');
                }
                i++;
                continue;

            }
            if(c!=',')
            st.push(c);
            i++;
        }
        return st.pop()=='t';
    }
}