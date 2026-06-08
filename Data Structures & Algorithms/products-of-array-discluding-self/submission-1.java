class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        pref[0]=1;
        for(int i=1;i<nums.length;i++) {
            pref[i]=pref[i-1]*nums[i-1];
        }
        int suff=1;
        for(int i=nums.length-2;i>=0;i--) {
            suff*=nums[i+1];
            pref[i]*=suff;
        }
        // int[] res = new int[nums.length];
        // for(int i=0;i<nums.length;i++) {
        //     res[i]=pref[i]*suff[i];
        // }

        return pref;
    }
}  
