
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for(int i=0; i < nums.length; i++){
            int complement = target - nums[i];
            Integer index = numMap.get(complement);
            if(index != null){
                return new int[]{index,i};
            }
            numMap.put(nums[i],i);
        }

        return null;
    }
}
//Time complexity:
//O(n) because in the worst case we will need to itterate over the entire array to find
//the pair if includes the last element.
//Space complexity:
//O(n) because the hashMap will grow with the size of the input. In the worst case
//we will need to add n-1 elements of the array to the hashmap.