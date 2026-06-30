class Solution {
    public int trap(int[] height) {
        int[] minHeight = new int[height.length];
        int max=0;
        for(int i=0;i<height.length;i++) {
            max=Math.max(max,height[i]);
            minHeight[i]=max;
        }
        max=0;
        for(int i=height.length-1;i>=0;i--) {
            max=Math.max(max,height[i]);
            minHeight[i]=Math.min(max,minHeight[i]);
        }        
        int sum = 0;
        for(int i=0;i<height.length;i++) {
            if(height[i]<minHeight[i]) {
                sum+=minHeight[i]-height[i];
            }
        }
        return sum;
    }
}
