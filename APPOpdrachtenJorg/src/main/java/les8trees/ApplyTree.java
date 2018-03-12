package les8trees;

public interface ApplyTree<T, U> {
    U apply(Tree<T> tree);
    U apply(TreeNode<T> treeNode);
}
