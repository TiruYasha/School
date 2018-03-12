package Lists.Stack.Queues;

public class HANStack<T> {
    HANLinkedList<T> stack;
    private int size;

    public HANStack(){
        stack = new HANLinkedList<>();
        size = 0;
    }

    public void push(T value){
        stack.addFirst(value);
        size++;
    }

    public T top() {
        return stack.get(0);
    }

    public T pop() {
        T top = top();
        stack.removeFirst();
        size--;
        return top;
    }

    public int getSize() {
        return size;
    }
}
