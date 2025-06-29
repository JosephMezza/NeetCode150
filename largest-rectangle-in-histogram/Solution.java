//Thinking: 4 key rectangles to consider [3,4,2], [1,4,2], [2,3,2], [1,2,3].
import java.util.Stack;

//Time complexity: O(n). Wow! Happy with this one but what hard. So, we itterate over the array once. Then, inside that loop, we
//at most push once, and pop once each element of that array into/off of a stack instead of having to itterate back each time to find the 
//next shortest.
// Basically, we itterate to the right once, but when we have a tall bar -> short bar, we backwards itterate on the STACK to pop all of the elements
// whose rectangles need to be finished. Lastly, if there is a stubborn value that keeps getting checked (Ex: A 1 a the beggining of the stack), this check
// takes O(1) time in each itteration so it's fine. So, we do forward (push) n elements, and then backward (pop) n elements (elements not popped in the main)
// loop are removed at the end in the loop to empty the stack).
// A stack is NEEDED, for example if we have [1,5,4,2], we can pop what is no longer needed (5&4) and keep the 1 until it can
// be popped later on. So rather than having to itterate over the entire array to keep looking for that 1, we have it in the stack!

//Space complexity: O(n) we need a stack to hold n height elements as we itterate over the heights.

//Simplified version
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stk = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<heights.length; i++){
            int start = i;

            while(!stk.isEmpty() && stk.peek()[0] > heights[i]){
                int[] prev = stk.pop();

                int height = prev[0];
                int width = i - prev[1];

                int area = height*width;

                maxArea = Math.max(area, maxArea);

                start = prev[1];
            }
            stk.push(new int[]{heights[i], start});
        }

        while(!stk.isEmpty()){
            int[] rec = stk.pop();

            int area = rec[0] * (heights.length - rec[1]);

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}


//Original solution! Shares the time and space complexity of the simplified version above.
//Difference, we do not put 0 on the stack and if there already exists a rectangle in progress with the same height as the current index, we don't put the new
//one with the same height onto the stack! We group them by just skipping the new one. For example, [2,2] on the stack we would ignore the second because we
//know it will be smaller than the one already on the stack.
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int maxArea = 0;

//         Stack<int[]> stk = new Stack<>();

//         for(int i=0; i<heights.length; i++){
//             if(!stk.isEmpty() && stk.peek()[0] > heights[i]){
//                 int s = 0;
//                 while(!stk.isEmpty() && stk.peek()[0] > heights[i]){
//                     int[] prev = stk.pop();

//                     int area = prev[0] * (i-prev[1]);

//                     maxArea = Math.max(area, maxArea);
//                     s = prev[1];
//                 }

//                 if(heights[i] == 0 || (!stk.isEmpty() && stk.peek()[0] == heights[i])){
//                     continue;
//                 }
//                 else{
//                     stk.push(new int[]{heights[i], s});
//                     continue;
//                 }
//             }

//                 if(heights[i] == 0){
//                     continue;
//                 }
//                 else{
//                     stk.push(new int[]{heights[i], i});
//                 }
//         }

//         //Anything left in the stack

//         while(!stk.isEmpty()){
//             int[] x = stk.pop();

//             int area = x[0] * (heights.length - x[1]);

//             maxArea = Math.max(area, maxArea);
//         }

//         return maxArea;
//     }
// }
