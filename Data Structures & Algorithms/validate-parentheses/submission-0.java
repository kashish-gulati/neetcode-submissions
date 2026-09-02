class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(st.isEmpty()) {
                st.push(c);
            } else {
                if(c==')') {
                    if(st.peek()=='(') st.pop();
                    else return false;
                } else if(c=='}'){
                    if(st.peek()=='{') st.pop();
                    else return false;
                } else if(c==']'){
                    if(st.peek()=='[') st.pop();
                    else return false;
                } else {
                    st.push(c);
                }
            }
        }
        return st.isEmpty();
    }
}
