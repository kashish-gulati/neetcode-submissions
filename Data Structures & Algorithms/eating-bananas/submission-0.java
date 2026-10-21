class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return binSearch(piles,h,1,Arrays.stream(piles).max().getAsInt() + 1);
    }

    public int binSearch(int[] piles, int h, int low, int high) {
        // System.out.println("low "+ low + " high " + high);
        if(low>=high) return -1;
        int m = (low+high)/2;
        if(evalK(piles,m)<=h && evalK(piles,m-1)>h) {
            return m;
        }
        else if(evalK(piles,m)>h) {
            return binSearch(piles,h,m+1,high);
        } else {
            return binSearch(piles,h,low,m);
        }
    }

    public int evalK(int[] piles, int k) {
        int hours=0;
        for(int i: piles) {
            hours+=Math.ceil((double)i/k);
        }
        return hours;
    }
}
