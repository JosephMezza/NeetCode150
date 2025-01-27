//Summary: We are calculating the product on the left and right side of each number. This
//can be done with 2 pass throughs of the array. From left to right (prefix)
//And right to left (suffix). By doing these 2 pass throughs, we build our final array.
//So each index of our results is just the prefix*postfix for that index.
//In this solution, we do NOT need an array to track the pre and suffix. They
//are tracked directly in the final array.
//Time complexity: It is O(2n) -> O(n) since itterate through the array and that's it.
//Space complexity: O(1) since we do all the calculations in the final array!
class Solution{
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];

        int prefix = 1;
        int suffix = 1;

        for(int i=0; i< nums.length; i++){
            results[i] = prefix;
            prefix *= nums[i];
        }

        for(int i=nums.length-1; i >= 0; i--){
            results[i] *= suffix;
            suffix *= nums[i];
        }

        return results;
    }
}

//Time complexity: In O(n): We need a way to save the result of the multiplications so we can re-use it.
//Space complexity: It is O(2n) -> O(n), since we we need to make arrays to hold pre and post. This can be improved!
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] prefix = new int[nums.length];
//         int[] suffix = new int[nums.length];

//         prefix[0] = nums[0];
//         for(int i = 1; i<nums.length; i++){
//             prefix[i] = prefix[i-1]*nums[i];
//         }

//         suffix[nums.length-1] = nums[nums.length-1];
//         for(int i=nums.length-2; i>=0; i--){
//             suffix[i] = suffix[i+1]*nums[i];
//         }

//         int[] output = new int[nums.length];

//         output[0] = 1*suffix[1];
//         output[nums.length-1]=prefix[nums.length-2]*1;
//         for(int i=1; i < nums.length-1; i++){
//             output[i] = prefix[i-1]*suffix[i+1];
//         }

//         return output;
//     }
// } 

//Division solution: Multiply all the numbers, and then just divide by the value at the current index. A few extra cases were
//added for zeros. We first want to find the result of multiplying all the numbers that are not 0. Then, 
//If there are 0 Zeros: We divide the result by the the number
//If there is 1 Zero: Then, we iterate over the array and when the zero is not the selected index, we just return 0.
//When it is the selected index, we return the result from before.
//If there is > 1 Zero: The answer will always be 0 because we can't avoid multiplying by 0.
//Time complexity: This is O(2n) -> O(n) because we only have to do 1 pass through of the array at a time.
//Space complexity: This is O(1) because the only array we create is the one we are returning.
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int result = nums[0];
//         int zeroCount = 0;
//         for(int i = 1; i<nums.length; i++){
//             if(nums[i] == 0){
//                 zeroCount++;
//                 continue;
//             }
//             result*=nums[i];
//         }

//         int[] products = new int[nums.length];

//         for(int i=0; i<nums.length;i++){
//             if(zeroCount == 0){
//                 products[i] = result/nums[i];
//             }
//             else if(zeroCount == 1){
//                 products[i] = nums[i] == 0 ? result : 0;
//             }
//             else{
//                 products[i] = 0;
//             }
//         }

//         return products;
//     }
// } 

//Naive: double for loop and keep going over array to calculate product in O(n^2)
//Time complexity: O(n^2) because we need to itterate over all elements for each element in the array to calculate the product.
//Space complexity: O(1) because we compute using the original array and then store the result in the array we are returning.

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] products = new int[nums.length];
//        for(int i=0; i< nums.length; i++){
//         products[i] = 1;
//         for(int j=0; j < nums.length; j++){
//             if(j == i){
//                 continue;
//             }
//             products[i] *= nums[j];
//         }
//        } 
//        return products;
//     }
// }  


