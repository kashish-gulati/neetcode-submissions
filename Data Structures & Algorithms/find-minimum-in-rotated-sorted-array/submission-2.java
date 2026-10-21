class Solution {
    public int findMin(int[] nums) {
        return nums[binSearch(nums,0,nums.length)];
    }

    public int binSearch(int nums[], int low, int high) {
        // System.out.println("low "+ low + " high "+ high);
        if(nums[low]<=nums[high-1]) return low;
        int m = (low+high)/2;

        if((m==high-1 || nums[m]<nums[m+1]) && (m==low || nums[m]<nums[m-1])) return m;
        
        if(nums[m]>nums[high-1]) {
            return binSearch(nums,m+1,high);
        }

        // if(nums[m]<nums[low]) {
            return binSearch(nums,low,m);
        // }

    }
}
