class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<AbstractMap.SimpleEntry<Integer,Integer>> ls = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            while(!ls.isEmpty() && ls.peek().getValue()<temperatures[i]) {
                AbstractMap.SimpleEntry<Integer,Integer> pair = ls.pop();
                res[pair.getKey()] = i-pair.getKey();
            }
            ls.push(new AbstractMap.SimpleEntry<Integer,Integer>(i,temperatures[i]));
        }

        while(!ls.isEmpty()) {
            AbstractMap.SimpleEntry<Integer,Integer> pair = ls.pop();
            res[pair.getKey()] = 0;
        }
        return res;
    }
}
