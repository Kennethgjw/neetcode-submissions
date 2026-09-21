class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack; // keeps track of the minimum values

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        // if val is smaller than current minimum, push
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int removed = stack.pop();

        // if removed value is also value of current minimum, remove from minstack as well
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
