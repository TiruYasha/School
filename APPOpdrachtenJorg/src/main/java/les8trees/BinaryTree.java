package les8trees;

public class BinaryTree<AnyType> {

    public static final int ROOT_DEPTH = 0;
    public BinaryTreeNode<AnyType> root;

    public BinaryTree() {
    }

    public int size() {
        return root.size();
    }

    public int calculateOneNonNullChild() {
        return root.calculateOneNonNullChild();
    }

    public int calculateTwoNonNullChildren() {
        return root.calculateTwoNonNullChildren();
    }

    public String getPreOrder() {
        return root.getPreOrder(ROOT_DEPTH);
    }

    public String getPostOrder() {
        return root.getPostOrder(ROOT_DEPTH);
    }

    public String getInOrder() {
        return root.getInOrder(ROOT_DEPTH);
    }

    public static int substract(BinaryTree<Integer> binaryTree) {
        return binaryTree.root.substract(ROOT_DEPTH);
    }

    @Override
    public String toString() {
        return getInOrder();
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.root = new BinaryTreeNode<Integer>(6,
                new BinaryTreeNode<Integer>(5),
                new BinaryTreeNode<Integer>(4,
                        new BinaryTreeNode<Integer>(2),
                        new BinaryTreeNode<Integer>(3, null, new BinaryTreeNode<Integer>(8))));
        System.out.println(binaryTree.toString());

        System.out.println();
        System.out.println("C: "+ BinaryTree.substract(binaryTree));
        System.out.println();

        binaryTree.mirror();

        System.out.println(binaryTree.toString());
    }

    private void mirror() {
        root.mirror();
    }
}
