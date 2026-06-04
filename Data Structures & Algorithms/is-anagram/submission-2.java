class Solution {
    public boolean isAnagram(String s, String t) {
        Map<String, Integer> alphabetMap = new HashMap<>();

        for(String c:s.split("")) {
            if(alphabetMap.containsKey(c)) {
                alphabetMap.put(c,alphabetMap.get(c)+1);
            } else {
                alphabetMap.put(c,1);
            } 
        }

        for(String c:t.split("")) {
            if(alphabetMap.containsKey(c) && alphabetMap.get(c)>0){
                alphabetMap.put(c,alphabetMap.get(c)-1);
            } else {
                return false;
            }
        }

        for(String c:s.split("")) {
            if(alphabetMap.get(c)>0){
                return false;
            }
        }

        return true;

    }
}
