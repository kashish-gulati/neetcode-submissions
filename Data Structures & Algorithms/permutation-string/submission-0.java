class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for(int i=0;i<s1.length();i++) {
            a1[s1.charAt(i)-'a']++;
            a2[s2.charAt(i)-'a']++;
        }
        if(eqArr(a1,a2)) return true;
        for(int i=s1.length();i<s2.length();i++) {
            a2[s2.charAt(i)-'a']++;
            a2[s2.charAt(i-s1.length())-'a']--;
            if(eqArr(a1,a2)) return true;
        }
        return false;
    }

    public boolean eqArr(int[] a1, int[] a2) {
        for(int i=0;i<26;i++) {
            if(a1[i]!=a2[i]) return false;
        }
        return true;
    }
}
