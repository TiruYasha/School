package les5listsstacksqueues;

public class Quack<AnyType> {

    private int size;
    private LinkedList<AnyType> list;

    public Quack() {
        size = 0;
        list = new LinkedList<>();
    }

    //Queue
    public void enqueue(AnyType value) {
        list.addFirst(value);
        size++;
    }

    public AnyType dequeue() {
        AnyType value = getFront();
        list.delete(list.getSize() - 1);
        size--;
        return value;
    }

    public AnyType getFront() {
        return list.get(list.getSize() - 1);
    }

    //Stack
    public void pop() {
        list.removeFirst();
        size--;
    }

    public AnyType top() {
        return list.get(0);
    }

    public AnyType topAndPop() {
        AnyType value = top();
        pop();
        return value;
    }

    public void push(AnyType value) {
        list.addFirst(value);
        size++;
    }

    public int getSize() {
        return size;
    }
}
