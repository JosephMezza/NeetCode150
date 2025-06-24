
import java.util.Stack;

//Time complexity: O(n) because we itterate over the tempuratures array only once. As for the the stack,
//we do not continuously read over it. Worst case, we add to the stack n elements, and then pop those n elements. So
//it is still linear.
//Space: O(n), since we require a Stack of maximum size n. And the output array is of size n (But I don't know if we count this).
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<int[]> stk = new Stack<>();//index, val

        for(int i=0; i<temperatures.length; i++){
            while(!stk.isEmpty() && temperatures[i] > stk.peek()[1]){
                results[stk.peek()[0]] = i - stk.peek()[0];
                stk.pop();
            }

            stk.push(new int[]{i, temperatures[i]});
        }

        return results;
    }
}
