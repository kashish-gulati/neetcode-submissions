class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length()-1;
        while(l<s.length() && !Character.isLetterOrDigit(s.charAt(l))) l++;
        while(h>=0 && !Character.isLetterOrDigit(s.charAt(h))) h--;
        while(l<h) {
            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(h))) {
                return false;
            }
            l++;
            h--;         
            while(l<s.length() && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(h>=0 && !Character.isLetterOrDigit(s.charAt(h))) h--;    
        }
        return true;
    }
}
