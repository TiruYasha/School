package les9binarysearchtrees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testFromSortedArray() {
        int[] array = {1, 3, 8, 10, 19, 22, 32};
        BinarySearchTree binarySearchTree = BinarySearchTree.fromSortedArray(array);
        assertEquals("        1\n" +
                "    3\n" +
                "        8\n" +
                "10\n" +
                "        19\n" +
                "    22\n" +
                "        32\n", binarySearchTree.toString());
        assertEquals(10, binarySearchTree.root.value);
        assertEquals(3, binarySearchTree.root.left.value);
        assertEquals(22, binarySearchTree.root.right.value);
        assertEquals(1, binarySearchTree.root.left.left.value);
        assertEquals(8, binarySearchTree.root.left.right.value);
        assertEquals(19, binarySearchTree.root.right.left.value);
        assertEquals(32, binarySearchTree.root.right.right.value);
    }

    @Test
    public void testFromUnsortedArray() {
        int[] array = {10, 32, 1, 8, 22, 19, 3};
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(array);
        assertEquals("        1\n" +
                "    3\n" +
                "        8\n" +
                "10\n" +
                "        19\n" +
                "    22\n" +
                "        32\n", binarySearchTree.toString());
        assertEquals(10, binarySearchTree.root.value);
        assertEquals(3, binarySearchTree.root.left.value);
        assertEquals(22, binarySearchTree.root.right.value);
        assertEquals(1, binarySearchTree.root.left.left.value);
        assertEquals(8, binarySearchTree.root.left.right.value);
        assertEquals(19, binarySearchTree.root.right.left.value);
        assertEquals(32, binarySearchTree.root.right.right.value);
    }
}