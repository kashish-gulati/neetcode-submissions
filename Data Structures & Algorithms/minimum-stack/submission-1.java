class MinStack {

    Stack<Integer> st;
    Stack<Integer> mst;

    public MinStack() {
        st = new Stack<>();
        mst = new Stack<>();
    }
    
    public void push(int val) {
        if(mst.isEmpty() || mst.peek()>=val) {
            mst.push(val);
        }
        st.push(val);
        // System.out.println(st.peek()+" "+mst.peek());
    }
    
    public void pop() {
        if(st.peek().equals(mst.peek())) {
            mst.pop();
        }
        st.pop();
        // System.out.println(st.peek()+" "+mst.peek());
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mst.peek();
    }
}
