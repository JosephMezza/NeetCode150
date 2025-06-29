import java.util.Arrays;
import java.util.Stack;

//Time complexity: O(n) since we itterate over the positions once to build our pairs, and then we itterate over our pairs once.
//Space complexity: O(n) we use a stack to keep track of the fleets, adding an element to the stack when a new fleet is found.
//Note: Only the LAST car (latest starting) in the fleet has an intercept we care about, that's why we can stick with it instead of changing it for the next
//comparison.
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {  

        int[][] pairs = new int[position.length][2];

        for(int i = 0; i<position.length; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0])); //Decreasing

        Stack<Double> stack = new Stack<>();

        for (int[] pair : pairs) {
            double time = (double)(target - pair[0]) / pair[1];
            
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}



//First draft. Works just like the cleaner version above! Uses itteration instead of a stack

// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {  
//         HashMap<Integer, Double> hash = new HashMap<>();

//         for(int i=0 ; i < position.length; i++){
//             hash.put(position[i], (double) (target-position[i])/speed[i]);
//         }

//         Arrays.sort(position);

//         int fleets = 0;
//         int i = position.length-1;

//         while(i>=0){
//             double reachI = hash.get(position[i]);

//             int j = i-1;
//             while(j>=0){
//                 double reachJ = hash.get(position[j]);

//                 if(reachJ > reachI){
//                     break;
//                 }
//                 j--;
//             }

//             fleets++;
//             i=j;
//         }

//         return fleets;

//     }
// }
