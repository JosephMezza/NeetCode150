//Thought process: This soultion uses the mid point to check if the number is in the list.
//So, we take the middle number on each itteration and we check. Is the nums[mid] == target? -> Return index if true
//Otherwise, if the target is less than, since this is sorted in ascending we will then assume it's to the left.
//But, this is not always true because it can be rotated. So in what case can we guarantee it WILL be on the left.
//1. If the left most number is greater than the mid, because then we know the target is boxed in by [BIG target? big]
//where BIG > big.
//2. If the left most number is less than or equal to the target
//Same thing applies for the right side of the mid if the number is greater than the mid. We can assume it's to the right.
//How can we confirm?
//1. If the right most number is smaller than the mid, then we know we ended the sequence [big BIG_TARGET? small]
//2. If the right most number is bigger than or equal to the target.
//We keep doing this to split the array in half for our search until we either find the number or we finish checking all mids
//and return -1.
//Time complexity: O(log(n))
//Space complexity: O(1) only require 3 integers for this.
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(l <= r){
            int mid = (l+r)/2;

            if(nums[mid] == target){
                return mid;
            }
        
            if(nums[mid] > target){
                if(nums[l] > nums[mid] || nums[l] <= target){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            else{
                if(nums[r] < nums[mid] || nums[r] >= target){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
