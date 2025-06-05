
import java.util.Stack;

//Time: O(n) since we need to traverse n characters in the original array of tokens
//Space: O(n) since we need to store the n integer tokens and the results of the operations in the stack.
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for (String val : tokens) {
            if (val.equals("*") || val.equals("-") || val.equals("+") || val.equals("/")) {
                int num2 = stk.pop();
                int num1 = stk.pop();

                switch (val) {
                    case "*" -> stk.push(num1 * num2);
                    case "/" -> stk.push(num1 / num2);
                    case "+" -> stk.push(num1 + num2);
                    case "-" -> stk.push(num1 - num2);
                }
            } else {
                stk.push(Integer.parseInt(val));
            }
        }

        return stk.pop();
    }
}