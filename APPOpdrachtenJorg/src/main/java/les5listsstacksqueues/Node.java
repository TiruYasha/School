package les5listsstacksqueues;

public class Node<T> {
    public Node next;
    protected T value;

    public Node() {

    }

    public Node(T value) {
        this.setValue(value);
    }

    public Node(T value, Node next) {
        this.next = next;
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node node) {
        next = node;
    }

    public Node getNext() {
        return next;
    }
}
