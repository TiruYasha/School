package les8trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {

    private static Tree<String> tree;

    private static ApplyTree addOneToEveryNode;

    @Before
    public void initialize() {
        tree = new Tree<>();
        addOneToEveryNode = new AddOneToEveryNode();
    }

    @Test
    public void testToString() {
        tree.root = new TreeNode<String>("A");
        tree.root.child = new TreeNode<String>("B");
        tree.root.child.child = new TreeNode<String>("D");
        tree.root.child.sibling = new TreeNode<String>("C");
        tree.root.child.sibling.child = new TreeNode<String>("E");
        assertEquals("A\n" +
                "    B\n" +
                "        D\n" +
                "    C\n" +
                "        E\n", tree.toString());
    }

    @Test
    public void testAddOneToEveryNode() {
        tree.root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        addOneToEveryNode.apply(tree);
        assertEquals(2, tree.root.value);
        assertEquals(3, tree.root.child.value);
        assertEquals(4, tree.root.sibling.value);
    }

}