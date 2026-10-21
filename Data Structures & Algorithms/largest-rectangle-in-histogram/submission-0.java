class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<heights.length;i++) {
            // System.out.println("*****right it"+i+" "+st.peek());
            if(heights[i]>=heights[st.peek()]) st.push(i);
            else {
                while(!st.empty() && heights[i]<heights[st.peek()]) {
                    int el = st.pop();
                    // System.out.println("*****right "+i+" "+el);
                    right[el] = i-el;
                }
                st.push(i);
            }
        }
        while(!st.empty()) {
            int el = st.pop();
            right[el] = heights.length-el;
        }

        st.push(heights.length-1);
        for(int i=heights.length-2;i>=0;i--) {
            if(heights[i]>=heights[st.peek()]) st.push(i);
            else {
                while(!st.empty() && heights[i]<heights[st.peek()]) {
                    int el = st.pop();
                    left[el] = el-i;
                }
                st.push(i);
            }
        }

        while(!st.empty()) {
            int el = st.pop();
            left[el] = el+1;
        }

        int max = 0;
        for(int i = 0; i<heights.length;i++) {
            // System.out.println(""+i+" "+left[i]+" "+right[i]);
        }

        for(int i=0;i<heights.length;i++) {
            int area = heights[i]*(right[i]+left[i]-1);
            max = Math.max(max,area);
        }

        return max;
    }
}
