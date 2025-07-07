//Gab helped with this! <3 She saw that if nums[mid] > nums[r] then that means the minimum is somewhere between mid and r (so on the right side). Else it's on the left of mid!
//Time complexity: O(log(n)) because after each itteration we are cutting the size of the array in half.
//Space complexity: O(1) only need 4 integers and we find the minimum element in memory.
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int min = nums[0];

        while(l <= r){
            int mid = (l + r)/ 2;

            min = Math.min(nums[mid], min);

            if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = mid -1;
            }
        }

        return min;
    }
}
