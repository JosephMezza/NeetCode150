//Time complexity: O(n) itterate n times to fill the array.
//Space compelexity: O(1) extra memory, O(n) for the list that is output.

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> nums = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(i % 15 == 0){
                nums.add("FizzBuzz");
            }
            else if(i % 3 == 0){
                nums.add("Fizz");
            }
            else if(i % 5 == 0){
                nums.add("Buzz");
            }
            else{
                nums.add(Integer.toString(i));
            }
        }
        return nums;
    }
}