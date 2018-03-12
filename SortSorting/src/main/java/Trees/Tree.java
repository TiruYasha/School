package Trees;


public class Tree<T> {

    private TreeNode<T> firstNode;

    public Tree(T firstNode){
        this.firstNode = new TreeNode<>(firstNode);
    }

    public void addChild(TreeNode<T> parent, T child){
        parent.setChild(new TreeNode<>(child));
    }

    public void addSibling(TreeNode<T> childOrSibling, T sibling){
        childOrSibling.setSibling(new TreeNode<>(sibling));
    }
}
