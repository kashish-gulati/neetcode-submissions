class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s: strs) {
            encoded.append(""+s.length()+"#"+s);
        }
        System.out.println("enc:"+encoded);
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> dec = new ArrayList<>();
        int count=0;
        boolean n=true;
        StringBuilder s = new StringBuilder();
        for(char ch: str.toCharArray()) {
            if(n) {
                System.out.print("n."+ch+" ");
                if(ch=='#') {
                    if(count!=0) {
                        n=false;
                    } else {
                        dec.add("");
                    }
                } else {
                    count=count*10+(ch-'0');
                }
            } else {
                System.out.print("c."+ch+" ");
                s.append(ch);
                count--;
                if(count==0) {
                    n = true;
                    dec.add(s.toString());
                    s.setLength(0);
                }
            }
        }
        return dec;
    }
}
