
import java.util.Arrays;

//Time complexity: It is O(n*log(n)) where n is the size of the array. The most costly operation
//is sorting the array which is n*log(n) and then we itterate over it linearly so n. O(n*log(n) + n) -> O(n*log(n)) 
//Space complexity: It is O(1) since we porform the sort on the starting array and we use the max and localMax
//ints to track the maximum consecutive streak.
class Solution {
    public int longestConsecutive(int[] nums) {
        //[]
        if(nums == null || nums.length == 0){
            return 0;
        }
        //[1]
        if(nums.length == 1){
            return 1;
        }

        Arrays.sort(nums);

        //1,2,3
        //1,3,5
        //2,3,4,4,5,10,20
        //1,3,4,6,7,8,20
        int max = 0;
        for(int i=0; i < nums.length-1;i++){
            int localMax = 1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] == nums[j-1]){
                    continue;
                }

                if(nums[i] + localMax != nums[j]){
                    i = j-1;
                    break;
                }

                localMax++;
            }

            max = Math.max(localMax, max);
        }

        return max;
    }
}

//Time complexity: It is O(n^2) since we need to itterate over the array once again for each element to see
//if it can make a sequence.
//Space complexity: It is O(n) since we need a HashSet to hold each element of the array.
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();

//         for(int num : nums){
//             set.add(num);
//         }

//         int max = 0;
//         for(int num : nums){
//             int localMax = 1;
//             for(int n : nums){
//                 if(!set.contains(num+localMax)){
//                     break;
//                 }
//                 localMax++;
//             }

//             if(localMax > max){
//                 max = localMax;
//             }

//         }
//         return max;
//     }
// }
