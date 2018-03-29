package Toets.dieren;

public class IdentificationNode<T> {

    public String question;
    public T value;
    public IdentificationNode<T> left;
    public IdentificationNode<T> right;
    public IdentificationNode<T> parent;

    public IdentificationNode(T value) {
        this.value = value;
    }

    public IdentificationNode(String question) {
        this.question = question;
    }

    public IdentificationNode<T> getLeft() {
        return left;
    }

    public void setLeft(IdentificationNode<T> left) {
        this.left = left;
    }

    public IdentificationNode<T> getRight() {
        return right;
    }

    public void setRight(IdentificationNode<T> right) {
        this.right = right;
    }

    public IdentificationNode<T> getParent() {
        return parent;
    }

    public void setParent(IdentificationNode<T> parent) {
        this.parent = parent;
    }
}
