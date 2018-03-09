package Lists.Stack.Queues;

public class HANLinkedList<T> {
    Node<T> head;

    public HANLinkedList(){
        head = new Node<>();
    }

    public void addFirst(T value) {
        if(head.getNextNode() == null){
            head.setNextNode(new Node<>(value));
        } else {
            Node<T> newNode = new Node<>(value);
            newNode.setNextNode(head.getNextNode());
            head.setNextNode(newNode);
        }
    }

    public void removeFirst() {
        if(head.getNextNode().getNextNode() == null) {
            head.setNextNode(null);
        }else{
            Node<T> oldNode = head.getNextNode();
            head.setNextNode(oldNode.getNextNode());
            oldNode.setNextNode(null);
        }
    }

    public void insert(int index, T value) {
        Node<T> nodeToReferenceTheCorrectIndex = getNode(index -1);
        insertNode(nodeToReferenceTheCorrectIndex, value);
    }

    private void insertNode(Node<T> node, T value) {
        Node<T> nextNode = node.getNextNode();
        Node<T> newNode = new Node<>(value);
        newNode.setNextNode(nextNode);

        node.setNextNode(newNode);
    }

    public void delete(int index) {
        Node<T> nodeToReferenceTheCorrectIndex = getNode(index -1);

        deleteNodeAfterGivenNode(nodeToReferenceTheCorrectIndex);
    }

    private void deleteNodeAfterGivenNode(Node<T> node) {
        Node<T> nodeToDelete = node.getNextNode();
        Node<T> nodeToKeep = nodeToDelete.getNextNode();

        node.setNextNode(nodeToKeep);
        nodeToDelete.setNextNode(null);
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    private Node<T> getNode(int index){
        Node<T> node = head.getNextNode();

        for(int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }
}
