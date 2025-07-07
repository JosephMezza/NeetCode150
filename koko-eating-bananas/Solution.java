
import java.util.Arrays;

//Optimized version!
//Time complexity: O(n + n * log(m)) -> O(n*log(m)). First n can be ignored because n*log(m) is bigger. 
//We need to go n element of the array log(m) times because we keep splitting the possibility of k in half with each itteration.
//Space complexity: O(1) Only need a few integers to keep track of min, max, and the best result found so far.
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minK = 1;
        int maxK = Arrays.stream(piles).max().getAsInt(); //Good to know!
        int res = maxK;

        while(minK <= maxK){
            int mid = (maxK + minK)/2; //Can also do this if scared of overflow! int mid = minK + (maxK - minK) / 2;

            int hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double)pile/mid);
            }

            if(hours<=h){
                res = mid;
                maxK = mid-1;
            }
            else{
                minK = mid + 1;
            }
        }

        return res;
    }
}




//Time complexity: O(n*m), where n is the length of the array, and m is the greatest number of bananas in a pile. We basically need to go from 1 to the maximum
//possible min of m. Because in the question it says piles.length <= h so in the worst case, we consume each stack in one hour, and we can guarantee we consume
//each stack every hour by picking k = pile with most bananas.
//Space complexity: O(1) no extra space required, just 2 integers.
// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int k = 1;
//         while(true){
//             int hours = 0;
//             for(int pile : piles){
//                 hours += Math.ceil(((double) pile)/k);
//             }

//             if(hours <= h){
//                 return k;
//             }
//             else{
//                 k++;
//             }
//         }
//     }
// }
