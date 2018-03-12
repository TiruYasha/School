package Trees;

public class TreeNode<T> {

    private TreeNode<T> sibling;
    private TreeNode<T> child;

    private T value;

    public TreeNode(T value){

    }

    public TreeNode<T> getSibling() {
        return sibling;
    }

    public void setSibling(TreeNode<T> sibling) {
        this.sibling = sibling;
    }

    public TreeNode<T> getChild() {
        return child;
    }

    public void setChild(TreeNode<T> child) {
        this.child = child;
    }
}
