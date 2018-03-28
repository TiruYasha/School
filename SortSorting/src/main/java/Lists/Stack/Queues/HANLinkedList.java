package Lists.Stack.Queues;

import java.util.Iterator;

public class HANLinkedList<T> implements Iterable<T>, Iterator<T> {

    Node<T> head;

    private int size = 0;
    private Node<T> currentNode;

    public HANLinkedList() {
        head = new Node<>();
        currentNode = head;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T value) {
        if (head.getNextNode() == null) {
            head.setNextNode(new Node<>(value));
        }
        else {
            Node<T> newNode = new Node<>(value);
            newNode.setNextNode(head.getNextNode());
            head.setNextNode(newNode);
        }

        size++;
    }

    public void removeFirst() {
        if (head.getNextNode().getNextNode() == null) {
            head.setNextNode(null);
        }
        else {
            Node<T> oldNode = head.getNextNode();
            head.setNextNode(oldNode.getNextNode());
            oldNode.setNextNode(null);
        }

        size--;
    }

    public void insert(int index, T value) {
        if (index == 0) {
            addFirst(value);
        }
        else {
            Node<T> nodeToReferenceTheCorrectIndex = getNode(index - 1);
            insertNode(nodeToReferenceTheCorrectIndex, value);
            size++;
        }
    }

    public void delete(int index) {
        Node<T> nodeToReferenceTheCorrectIndex = getNode(index - 1);

        deleteNodeAfterGivenNode(nodeToReferenceTheCorrectIndex);
        size--;
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    @Override
    public boolean hasNext() {
        return currentNode.getNextNode() != null;

    }

    @Override
    public T next() {
        currentNode = currentNode.getNextNode();
        return currentNode.getValue();
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    private void insertNode(Node<T> node, T value) {
        Node<T> nextNode = node.getNextNode();
        Node<T> newNode = new Node<>(value);
        newNode.setNextNode(nextNode);

        node.setNextNode(newNode);
    }

    private Node<T> getNode(int index) {
        Node<T> node = head.getNextNode();

        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }

    private void deleteNodeAfterGivenNode(Node<T> node) {
        Node<T> nodeToDelete = node.getNextNode();
        Node<T> nodeToKeep = nodeToDelete.getNextNode();

        node.setNextNode(nodeToKeep);
        nodeToDelete.setNextNode(null);
    }
}
