package Lists.Stack.Queues;

import java.util.ArrayList;

public class Queue<AnyType> {

    private ArrayList<AnyType> array;

    public Queue() {
        array = new ArrayList<>();
    }

    public void enqueue(AnyType value) {
        array.add(value);
    }

    public AnyType dequeue() {
        AnyType value = getFront();
        array.remove(0);
        return value;
    }

    public AnyType getFront() {
        return array.get(0);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }
}
