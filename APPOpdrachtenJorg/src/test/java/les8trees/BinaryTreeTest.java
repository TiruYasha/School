package les8trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    public static BinaryTree<String> binaryTree;

    public static ApplyBinaryTree calculateSum;

    public static ApplyBinaryTree calculateTotalLeaves;

    @Before
    public void initialize() {
        binaryTree = new BinaryTree<>();
        binaryTree.root = new BinaryTreeNode<String>("A",
                new BinaryTreeNode<String>("B",
                        new BinaryTreeNode<String>("C",
                                new BinaryTreeNode<String>("D"),
                                new BinaryTreeNode<String>("E")),
                        new BinaryTreeNode<String>("F")),
                new BinaryTreeNode<String>("G",
                        new BinaryTreeNode<String>("H"),
                        new BinaryTreeNode<String>("I")));
        calculateSum = new CalculateSum();
        calculateTotalLeaves = new CalculateTotalLeaves<>();
    }

    @Test
    public void testPreOrder() {
        assertEquals("A\n" +
                "    B\n" +
                "        C\n" +
                "            D\n" +
                "            E\n" +
                "        F\n" +
                "    G\n" +
                "        H\n" +
                "        I\n", binaryTree.getPreOrder());
    }

    @Test
    public void testPostOrder() {
        assertEquals("            D\n" +
                "            E\n" +
                "        C\n" +
                "        F\n" +
                "    B\n" +
                "        H\n" +
                "        I\n" +
                "    G\n" +
                "A\n", binaryTree.getPostOrder());
    }

    @Test
    public void testInOrder() {
        assertEquals("            D\n" +
                "        C\n" +
                "            E\n" +
                "    B\n" +
                "        F\n" +
                "A\n" +
                "        H\n" +
                "    G\n" +
                "        I\n", binaryTree.getInOrder());
    }

    @Test
    public void testSize() {
        assertEquals(9, binaryTree.size());
    }

    @Test
    public void testSumOne() {
        binaryTree.root = new BinaryTreeNode<String>("*",
                new BinaryTreeNode<String>("1"),
                new BinaryTreeNode<String>("*",
                        new BinaryTreeNode<String>("2"),
                        new BinaryTreeNode<String>("3")));
        assertEquals(6f, calculateSum.apply(binaryTree));
    }

    @Test
    public void testSumTwo() {
        binaryTree.root = new BinaryTreeNode<String>("+",
                new BinaryTreeNode<String>("*",
                        new BinaryTreeNode<String>("4"),
                        new BinaryTreeNode<String>("6")),
                new BinaryTreeNode<String>("5"));
        assertEquals(29f, calculateSum.apply(binaryTree));
    }

    @Test
    public void testSumThree() {
        binaryTree.root = new BinaryTreeNode<String>("*",
                new BinaryTreeNode<String>("4"),
                new BinaryTreeNode<String>("+",
                        new BinaryTreeNode<String>("6"),
                        new BinaryTreeNode<String>("5")));
        assertEquals(44f, calculateSum.apply(binaryTree));
    }

    @Test
    public void testCalulateTotalLeaves() {
        assertEquals(5, calculateTotalLeaves.apply(binaryTree));
    }

    @Test
    public void testCalculateTwoNonNullChildren() {
        assertEquals(4, binaryTree.calculateTwoNonNullChildren());
    }

    @Test
    public void testCalculateOneNonNullChild() {
        assertEquals(0, binaryTree.calculateOneNonNullChild());
    }

}