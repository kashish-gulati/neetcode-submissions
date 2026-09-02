class Solution {
    public String minWindow(String s, String t) {
        //init scount tcount hashmaps
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        //fill t hashmap
        for(char c: t.toCharArray()) {
            addChar(tMap, c);
        }
        //init sstart at -1
        int sstart=0;
        int tm = 0;
        // init common as ""
        String common = "";
        //for loop through s
        for(int i=0;i<s.length();i++) {
            //add si to scount
            tm = addCharS(sMap,tMap, s.charAt(i), tm);
            //if sstart is -1, make sstart i -----skipped
            //if(t.length>si-sstart+1) continue
            if(t.length()>i-sstart+1) continue;
            //while(scount equals tcount && t.length<=si-sstart+1)
            while(tm==t.length() && t.length()<=i-sstart+1) {
                //if equal, comp common with substr(sstart,si)
                if("".equals(common) || common.length()>i-sstart+1) {
                    common=s.substring(sstart,i+1);
                }
                //sstart++
                tm = removeCharS(sMap,tMap, s.charAt(sstart++), tm);
                //remove sstart from scount
            }
        }
        return common;

    }

    private void addChar(Map<Character,Integer> map, char c) {
        if(map.containsKey(Character.valueOf(c))) {
            map.put(Character.valueOf(c),1+map.get(Character.valueOf(c)));
        } else {
            map.put(Character.valueOf(c),1);
        }
    }

    private int addCharS(Map<Character,Integer> sMap, Map<Character,Integer> tMap, char c, int tm) {
        if(sMap.containsKey(Character.valueOf(c))) {
            sMap.put(Character.valueOf(c),1+sMap.get(Character.valueOf(c)));
        } else {
            sMap.put(Character.valueOf(c),1);
        }
        if(tMap.containsKey(Character.valueOf(c))) {
            if(tMap.get(Character.valueOf(c))>=sMap.get(Character.valueOf(c))) {
                tm++;
            }
        }
        return tm;
    }

    private void removeChar(Map<Character,Integer> map, char c) {
        map.put(Character.valueOf(c),map.get(Character.valueOf(c))-1);
    }

    private int removeCharS(Map<Character,Integer> sMap, Map<Character,Integer> tMap, char c, int tm) {
        sMap.put(Character.valueOf(c),sMap.get(Character.valueOf(c))-1);
        if(tMap.containsKey(Character.valueOf(c))) {
            if(tMap.get(Character.valueOf(c))>sMap.get(Character.valueOf(c))) {
                tm--;
            }
        }
        return tm;
    }

    private boolean mapMatch(Map<Character,Integer> sMap, Map<Character,Integer> tMap){
        return !tMap.keySet().stream().anyMatch(c -> !sMap.containsKey(c) || sMap.get(c)<tMap.get(c));
    }
}
