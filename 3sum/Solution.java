import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time complexity: This is (1) O(n^3) *  (2) O(n^3). (1) is because we need to check every
//possible triple which is n^3, where n is the size of the array. We need to multiply this
//because we need to check for unique triples, so in the worst case, we need to itterate over
//a list that could have every triple in it at size n^3. We also do a sort which is n*log(n). So n^3*(n^3+(n*log(n))) = O(n^6).
//VERY INNEFICCIENT. Thinking of a better solution.
//Time complexity: This is O(1) since our list is required by the function and we use
//the same one to check for duplicated so no extra memory.
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {

//         List<List<Integer>> triples = new ArrayList<>();

//         for(int i=0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 for(int k=j+1; k<nums.length; k++){
//                     if(nums[i]+nums[j]+nums[k] == 0){
//                         List<Integer> t = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
//                         Collections.sort(t);
//                         boolean alreadyExists = false;
//                         for(List<Integer> l : triples){
//                             if(l.equals(t)){
//                                 alreadyExists = true;
//                                 break;
//                             }
//                         }
//                         if(alreadyExists){
//                             continue;
//                         }

//                         triples.add(t);
//                     }
//                 }
//             }
//         }
//         return triples;
//     }
// }

// Time complexity: O(n^2). 1. We sort the list which is n*log(n) and then we
// use an outer loop to itterate over the array once for our "a" value, and then an
// inner loop to solve Two Sum II. The third loop just shortens the checks of the
// inner loop (not itterating over the elements again) so it does not need to be
// added. That gives us O(n*log(n) + n^2), which is O(n^2)/.

//Space complexity: Can be O(1), O(log(n)) or O(n) depending on sorting algorithm.
//In Java for primitive types, it uses dual pivot quicksort which is O(log(n)).

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int a = nums[i];

            if(a > 0){ //If "a" is > 0, then we won't be able to sum to 0 if the list is sorted.
                break;
            }

            if(i>0 && nums[i-1] == a){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                int sum = a + nums[left] + nums[right];
                if(sum == 0){
                    list.add(Arrays.asList(a,nums[left], nums[right]));
                    left ++;
                    right --;
                    while(left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                }
                else if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
            }
        }
        return list;
    }
}

