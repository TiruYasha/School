package les8trees;

public class Tree<AnyType> {

    public static final int ROOT_DEPTH = 0;

    public TreeNode<AnyType> root;

    @Override
    public String toString() {
        return root.toString(ROOT_DEPTH);
    }
}
