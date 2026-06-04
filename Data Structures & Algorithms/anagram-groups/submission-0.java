class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> countMap = new HashMap<>();
        for(String str: strs) {
            String countS = countChar(str);
            if(!countMap.containsKey(countS)) {
                countMap.put(countS,new ArrayList<>());
            }
            countMap.get(countS).add(str);
            //append to countChar entry in map
        }
        return new ArrayList<>(countMap.values());
    }

    public String countChar(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c-'a']++;
        }
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<26;i++) {
            res.append('a'+i);
            res.append(Integer.toString(count[i]));
        }
        return res.toString();
    }
}
