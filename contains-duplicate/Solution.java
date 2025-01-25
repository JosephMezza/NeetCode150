
import java.util.HashSet;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){
            if(hashSet.contains(nums[i])){
                return true;
            }
            hashSet.add(nums[i]);
        }

        return false;
    }
}
//Time complexity:
//O(n) because we would have to itterate over n elements of the array to find a duplicate
//element if it's the last element.
//Space complexity:
//O(n) because we would need to add n elements to the hashset if there are no duplicates.