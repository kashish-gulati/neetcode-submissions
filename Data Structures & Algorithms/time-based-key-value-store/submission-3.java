class TimeMap {

    Map<String,TreeMap<Integer,String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(timeMap.containsKey(key)) {
            timeMap.get(key).put(timestamp,value);
        } else {
            timeMap.put(key, new TreeMap<>(Map.of(timestamp,value)));
        }
    }
    
    public String get(String key, int timestamp) {
        return Optional.ofNullable(
                timeMap.get(key)
            ).map(tm -> tm.floorEntry(timestamp))
            .map(e -> e.getValue())
            .orElse("");
    }
}
