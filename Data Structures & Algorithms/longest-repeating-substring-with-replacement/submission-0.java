class Solution {
    public int characterReplacement(String s, int k) {
        int[] cc = new int[26];
        int st=0,ed=0,mf=0,max=0;
        while(ed < s.length()){
            cc[s.charAt(ed)-'A']++;
            //calc most frequent
            mf=largestCount(cc);
            
            //if(length-mostFreq<=k) checkMax
            int windowLen = ed - st + 1;
            if(windowLen - mf <= k) {
                max = Math.max(max, windowLen);
                ed++;
            }
            //else inc st
            else {
                cc[s.charAt(st) - 'A']--;
                st++;
                ed++;
            }
        }
        return max;
    }

    int largestCount(int[] cc) {
        int res = 0;
        for (int i : cc) res = Math.max(res, i);
        return res;
    }
}
