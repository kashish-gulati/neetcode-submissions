class Solution {
    public int maxArea(int[] heights) {
        int low = 0;
        int high = heights.length-1;
        int max = 0;
        int area=0;
        while(low<high) {
            area = Math.min(heights[low],heights[high])*(high-low);
            max = Math.max(max,area);
            if(heights[low]>heights[high]) {
                high--;
            } else {
                low++;
            }
        }
        return max;
    }
}
