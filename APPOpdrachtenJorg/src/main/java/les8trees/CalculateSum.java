package les8trees;

public class CalculateSum implements ApplyBinaryTree<String, Float> {

    @Override
    public Float apply(BinaryTree<String> binaryTree) {
        return apply(binaryTree.root);
    }

    @Override
    public Float apply(BinaryTreeNode<String> binaryTreeNode) {
        if (binaryTreeNode == null) {
            throw new NullPointerException();
        } else if (binaryTreeNode.value.equals("*")) {
            return apply(binaryTreeNode.left) * apply(binaryTreeNode.right);
        } else if (binaryTreeNode.value.equals("/")) {
            return apply(binaryTreeNode.left) / apply(binaryTreeNode.right);
        } else if (binaryTreeNode.value.equals("+")) {
            return apply(binaryTreeNode.left) + apply(binaryTreeNode.right);
        } else if (binaryTreeNode.value.equals("-")) {
            return apply(binaryTreeNode.left) - apply(binaryTreeNode.right);
        } else {
            return Float.valueOf(binaryTreeNode.value);
        }
    }
}
