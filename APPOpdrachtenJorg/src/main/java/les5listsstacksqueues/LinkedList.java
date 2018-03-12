package les5listsstacksqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<AnyType> implements Iterable<AnyType>, Iterator<AnyType> {

    protected Node<AnyType> header;
    protected int size;

    private int count = 0;

    public LinkedList() {
        header = new Node<AnyType>();
        size = 0;
    }

    public void setFirst(Node<AnyType> node) {
        header.next = node;
    }

    public void addFirst(AnyType value) {
        Node tempNode = new Node(value);
        tempNode.setNext(header.getNext());
        header.setNext(tempNode);
        size++;
    }

    public void removeFirst() {
        if(isEmpty()) {
            return;
        }
        header.setNext(header.getNext().getNext());
        size--;
    }

    public void insert(int index, AnyType value) {
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node tmpNode = new Node(value);
        Node node = header;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        tmpNode.setNext(node.getNext());
        node.setNext(tmpNode);
        size++;
    }

    public void delete(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = header;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
        size--;
    }

    public AnyType get(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = header;
        for (int i = 0; i < index + 1; i++) {
            node = node.getNext();
        }
        return (AnyType) node.getValue();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String value = "";
        Node node = header;
        for (int i = 0; i < size; i++) {
            node = node.getNext();
            value += "item " + i + ": " + node.getValue() + "\n";
        }
        return value;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if(count < getSize()) {
            return true;
        }
        return false;
    }

    @Override
    public AnyType next() {
        if(count == getSize()) {
            throw new NoSuchElementException();
        }
        count++;
        return get(count - 1);
    }
}
