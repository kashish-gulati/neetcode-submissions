class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i: nums) {
            if(countMap.containsKey(Integer.valueOf(i))) {
                countMap.put(Integer.valueOf(i), countMap.get(Integer.valueOf(i))+1);
            } else {
                countMap.put(Integer.valueOf(i), 1);
            }
        }
        List<Integer> list = new ArrayList<>(countMap.keySet());
        list.sort((a, b) -> countMap.get(b) - countMap.get(a));
        for(int i=0; i<k; i++) {
            topK[i] = list.get(i);
        }
        return topK;
    }
}
