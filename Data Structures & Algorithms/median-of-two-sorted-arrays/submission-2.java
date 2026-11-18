class Solution {
    /*
    Assume a as smaller
    median comes after half(h) elems
    assume a.len/2 to be starting of a, then a has alen/2 and b has h-a.len/2
    assume -inf at left of all elems the arrays and +inf to right of all elems
    if(aleft<bright and bleft<aright) we have the required elems for median, calc the median accordingly
    else if(aleft>bright) we need to go left so that aleft is smaller
    else if(bleft>aright) we need to go right so that aright is larger
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a;
        int[] b;
        if(nums1.length<nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            a = nums2;
            b = nums1;
        }

        int h = ((a.length+b.length)/2);
        boolean ev = (a.length+b.length)%2==0;

        int l=0,r=a.length;
        while(l<=r) {
            int ma = l + (r-l)/2;
            int mb = h-ma;
            int ar = ma>=a.length? Integer.MAX_VALUE : a[ma];
            int br = mb>=b.length? Integer.MAX_VALUE : b[mb];
            int al = ma<=0? Integer.MIN_VALUE : a[ma-1];
            int bl = mb<=0? Integer.MIN_VALUE : b[mb-1];
            // System.out.printf("l:%d,r:%d,ma:%d,mb:%d,al:%d,ar:%d,bl%d,br:%d\n",l,r,ma,mb,al,ar,bl,br);
            if(al<=br && bl<=ar) {
                if(ev) {
                    return (double) (Math.max(al, bl) + Math.min(br,ar))/2;
                } else {
                    return Math.min(ar, br);
                }
            } else if (al>br) {
                r = ma-1;
            } else {
                l = ma+1;
            }
        }
        return -1;
    }
}


/*




*/
