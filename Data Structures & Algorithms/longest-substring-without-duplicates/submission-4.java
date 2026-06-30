class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2) return s.length();
        int max = 0;
        int[] asarr = new int[256];
        int st=0;
        asarr[s.charAt(0)]++;
        for(int i=1;i<s.length();i++) {
            asarr[s.charAt(i)]++;
            if(asarr[s.charAt(i)]>1) {
                max=Math.max(i-st,max);
                while(s.charAt(st)!=s.charAt(i)) {
                    asarr[s.charAt(st)]--;
                    st++;
                }
                st++;
                asarr[s.charAt(i)]--;
            }
        }
        max=Math.max(s.length()-st,max);
        return max;
    }
}
