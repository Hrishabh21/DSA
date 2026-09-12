class Solution {
    public boolean parseBoolExpr(String exp) {
        Stack<Character> st  = new Stack<>();
         Stack<Boolean> st2  = new Stack<>();
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
                while(st.peek()!='('){
                    st2.add((st.pop()=='t'));

                }
                st.pop();
                char ex = st.pop();
                while(st2.size()>1){
                    if(ex=='&'){
                        st2.push(st2.pop()&st2.pop());
                    }
                    else{
                        st2.push(st2.pop()|st2.pop());
                    }
                }
                if(ex=='!')
                st2.push(!st2.pop());
                i++;
                continue;

            }
            st.push(c);
            i++;
        }
        return st2.s;
    }
}