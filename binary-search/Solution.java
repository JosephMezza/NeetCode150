//IMPORTANT NOTE: int mid = left + (right - left) / 2; USE THIS TO FIND MID BECAUSE LEFT+RIGHT CAN OVERFLOW
//IF RESULT SURPASES 2^31 - 1.
// Second note: We need to do mid - 1, mid + 1 or else we would stay stuck in an infinite loop when the targer cannot be found.
//Ex: [4 6] (left = 4, right = 6, target = 5) so mid is (0+2)/2 = 1, so nums[mid]>target (6>5) so right = 1 again and we loop forever.
//That is why we need to do mid-1 in this case so that we trigger left<=right.
//We need to do left <= right and not left != right because let's say we have:
//[1 2 3] (left = 0, right = 2, target = 3) mid = (0+2)/2 = 1, nums[mid] < target so left = mid+1 (1 + 1 = 2). So you see we need to check even
//if left == right.

//Time complexity: O(log(n)) since we continuously cut the array in half and check the middle element against
//the target.

//Space complexity: O(1) this is done using the array given in the input and 3 integers to track the left, right and mid.

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (left + right)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return -1;
    }
}
