class TimeMap {
    record Entry(int ts, String val) {}

    Map<String,List<Entry>> timeMap;
    

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(timeMap.containsKey(key)) {
            timeMap.get(key).add(new Entry(timestamp,value));
        } else {
            timeMap.put(key, new ArrayList<>(List.of(new Entry(timestamp,value))));
        }
    }
    
    public String get(String key, int timestamp) {
        return binSearch(timeMap.get(key),timestamp);
    }

    //1,3 3

    private String binSearch(List<Entry> es, int targ) {
        if(es==null) return "";
        int low=0,high=es.size()-1;
        while(low<=high) {
            if(low==high) {
                if(es.get(low).ts<=targ) return es.get(low).val;
                else return "";
            }
            int mid = low + (high-low)/2;
            if(low==mid) {
                if(es.get(low).ts<=targ && es.get(low+1).ts>targ) return es.get(low).val;
                else low=mid+1;
            } else if(es.get(mid).ts<=targ) {
                low=mid;
            } else {
                high=mid-1;
            }
        }
        return "";
    }
}
