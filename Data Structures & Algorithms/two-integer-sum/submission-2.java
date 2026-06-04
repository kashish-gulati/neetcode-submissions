class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> s = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(!s.containsKey(nums[i])) s.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++) {
            if(s.containsKey(target-nums[i]) && s.get(target-nums[i])!=i ) {
                int[] ret = new int[2];
                if((i< s.get(target-nums[i]))) {
                    ret[0] = i;
                    ret[1] = s.get(target-nums[i]);
                } else {
                    ret[1] = i;
                    ret[0] = s.get(target-nums[i]);
                }
                return ret;
            }
        }
        return new int[2];
    }
}
