class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++) {
            findTarg(nums,i,res);
            while(i<nums.length-1 && nums[i+1]==nums[i]) i++;
        }
        return res;
    }


    public void findTarg(int[] nums, int i, List<List<Integer>> res) {
        int j=i+1;
        int k=nums.length-1;
        while(j<k) {
            if(nums[i]+nums[j]+nums[k]<0) {
                j++;
            } else if(nums[i]+nums[j]+nums[k]>0) {
                k--;
            } else {
                // System.out
                res.add(List.of(nums[i],nums[j],nums[k]));
                j++;
                while(j<nums.length && nums[j-1]==nums[j]) j++;
                k--;
                while(k>0 && nums[k+1]==nums[k]) k--;
            }
        }
    }
}
