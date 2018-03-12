package les8trees;

public class CalculateTotalLeaves<AnyType> implements ApplyBinaryTree<AnyType, Integer> {

    @Override
    public Integer apply(BinaryTree<AnyType> binaryTree) {
        return apply(binaryTree.root);
    }

    @Override
    public Integer apply(BinaryTreeNode<AnyType> binaryTreeNode) {
        if(binaryTreeNode == null) {
            return 0;
        }
        int value;
        if (binaryTreeNode.left == null && binaryTreeNode.right == null) {
            value = 1;
        } else {
            value = 0;
        }
        return value + apply(binaryTreeNode.left) + apply(binaryTreeNode.right);
    }
}
