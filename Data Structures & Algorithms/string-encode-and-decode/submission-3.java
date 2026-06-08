class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s: strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> dec = new ArrayList<>();
        int i=0;
        while(i<str.length()) {
            int j = str.indexOf('#',i);
            int num = Integer.parseInt(str.substring(i,j));
            dec.add(str.substring(j+1,j+1+num));
            i=j+1+num;
        }
        return dec;
    }
}
