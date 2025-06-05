//Time: O(1) all operations run in constant time. (Really depends on Java's implementation on Stack. List: O(1) amortized, LinkedList: O(1) always)
//Space: O(n) we need to store n values in the stack and up to n values in the min stack.
class MinStack {

    private Stack<Integer> min;
    private Stack<Integer> stk;

    public MinStack() {
        min = new Stack<>();
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(!min.isEmpty()){
            if(val <= min.peek()){
            min.push(val);  
            }
        }
        else{
            min.push(val);
        }

        stk.push(val);
    }
    
    public void pop() {
        int val = stk.peek();

        if(val == min.peek()){
            min.pop();
        }

        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
