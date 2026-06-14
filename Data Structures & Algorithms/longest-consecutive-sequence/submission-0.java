class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        int maxLength=0;
        for(int num: nums) {
            numset.add(num);
        }

        for(int num: nums) {
            if(!numset.contains(num-1)) {
                maxLength=Math.max(maxLength,checkSubsequenceLength(numset,num));
            }
        }
        return maxLength;

    }

    public int checkSubsequenceLength(Set<Integer> ns, int n) {
        if(ns.contains(n+1)) {
            return 1+checkSubsequenceLength(ns,n+1);
        } else {
            return 1;
        }
    }
}
