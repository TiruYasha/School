package les5listsstacksqueues;

public class Stack<AnyType> {

    private LinkedList<AnyType> stack;

    Stack() {
        stack = new LinkedList<>();
    }

    public void pop() {
        stack.removeFirst();
    }

    public AnyType top() {
        return stack.get(0);
    }

    public AnyType topAndPop() {
        AnyType value = top();
        pop();
        return value;
    }

    public void push( AnyType value) {
        stack.addFirst(value);
    }

    public int getSize() {
        return stack.getSize();
    }
}
