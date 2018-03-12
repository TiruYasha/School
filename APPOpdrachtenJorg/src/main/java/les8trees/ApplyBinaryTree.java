package les8trees;

public interface ApplyBinaryTree<T, U> {
    U apply(BinaryTree<T> binaryTree);
    U apply(BinaryTreeNode<T> binaryTreeNode);
}
