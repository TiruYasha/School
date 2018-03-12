package les8trees;

public class AddOneToEveryNode implements ApplyTree<Integer, Tree> {
    @Override
    public Tree apply(Tree<Integer> tree) {
        addOneToEveryNode(tree.root);
        return tree;
    }

    @Override
    public Tree apply(TreeNode<Integer> treeNode) {
        Tree tree = new Tree();
        tree.root = treeNode;
        return apply(tree);
    }

    private void addOneToEveryNode(TreeNode<Integer> treeNode) {
        if (treeNode != null) {
            treeNode.value++;
            addOneToEveryNode(treeNode.child);
            addOneToEveryNode(treeNode.sibling);
        }
    }
}
