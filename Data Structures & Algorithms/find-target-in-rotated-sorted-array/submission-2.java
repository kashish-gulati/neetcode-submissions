class Solution {
    public int search(int[] nums, int target) {
        // int min = binSearchMin(nums, 0, nums.length-1);
        // return binSearchRotate(nums,min,(min-1)%nums.length,target);
        return binSearchRotate(nums,0,nums.length-1,target);
    }

    // public int binSearchMin(int nums[], int low, int high) {
    //     // if(low>high) return -1;
    //     int mid = low+((high-low)/2);
    //     if(nums[(mid-1)%nums.length]>nums[mid]) return mid;
    //     // else if(mid-1<low) throw new RuntimeException("binSearchMin failed:mid-1 lower than low");
    //     else if(nums[mid]>nums[high]) return binSearchMin(nums,mid,high);
    //     else if(nums[mid]<nums[low]) return binSearchMin(nums,low,mid);
    //     else throw new RuntimeException("binSearchMin failed:no condition met,low:"+low+",high:"+high+",mid:"+mid);
    // }

    public int binSearchRotate(int nums[], int low, int high, int target) {
        // if(low==high) {
        //     if(nums[low]==target) return low;
        //     else return -1;
        // }
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(low==high) return -1;
            if(nums[mid]>=nums[low]) {
                if(target<nums[mid] && target>=nums[low]) high=mid-1;
                else low = mid+1;
            }
            else {
                if(target>nums[mid] && target<=nums[high]) low=mid+1;
                else high=mid-1;
            }
        }
        return -1;
        // int mid = (low+(((high-low)%nums.length)/2))%nums.length;
        // // System.out.println("low:"+low+",high:"+high+",mid:"+mid);
        // if(nums[mid]==target) return mid;
        // else if(nums[mid]>target) return binSearchRotate(nums,low,mid,target);
        // else return binSearchRotate(nums,mid,high,target);
    }
}
