
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Make hashmap with number and counts
//Make an array where we store the count as the index, and the number as the value
//in a list.
//Start from back of the list and grab the k biggest values
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        List<Integer>[] freq = new ArrayList[nums.length+1];
        
        for(int num : nums){
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
                
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Integer key : numCount.keySet()){
            freq[numCount.get(key)].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for(int i=freq.length-1; i>=0; i--){
            for(Integer j : freq[i]){
                res.add(j);
                if(res.size() == k){
                    int[] result = new int[k];

                    for(int q = 0; q<result.length;q++){
                        result[q] = res.get(q);
                    }
                    return result;
                }
            }
        }
        return null;
    }
}
//Time complexity: It is O(n) because we itterate over our initial numbers to put
//them in the hashmap in n time, then we initialize our array in n time, then
//we fill our array in n time, then we itterate over our array in n time to find the 
//k most frequent elements. This makes it O(n) since each itteration is separate.
//Space complexity: It is also O(n). Our hashmap is of O(n) in case each number is unique.
//The array will also be of maximum size O(n) in case the last index is used because
//all the numbers in the array are the same one. Our List of results will also be
//maximum size k, but k in the worst case is n. So nothing exceeds O(n).

