class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l+1<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid;
            }
            else{
                r=mid;
            }
        }
        return nums[l]==target?l:nums[r]==target?r:-1;
    }
}
