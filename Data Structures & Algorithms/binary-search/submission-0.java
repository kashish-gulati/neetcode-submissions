class Solution {
    public int search(int[] nums, int target) {
        return bsearch(nums,target,0,nums.length);
    }

    public int bsearch(int[] nums, int target, int low, int high) {
        if (low>=high) return -1;
        int m = (low+high)/2;
        if(nums[m]==target) return m;
        else if(nums[m]>target) return bsearch(nums,target,low,m);
        else return bsearch(nums,target,m+1,high);
    }
}
