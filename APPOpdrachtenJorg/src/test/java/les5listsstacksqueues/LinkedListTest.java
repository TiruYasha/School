package les5listsstacksqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<Integer> linkedList;

    private final static int value1 = 1;
    private final static int value2 = 2;
    private final static int value3 = 3;
    private final static int value4 = 4;

    @Before
    public void initialize() {
        linkedList = new LinkedList<>();
    }

    @Test
    public void testOneAddFirst() {
        linkedList.addFirst(value1);
        assertEquals((Integer) value1, linkedList.get(0));
    }

    @Test
    public void testTwoAddFirst() {
        linkedList.addFirst(value1);
        linkedList.addFirst(value2);
        assertEquals((Integer) value2, linkedList.get(0));
        assertEquals((Integer) value1, linkedList.get(1));
    }

    @Test
    public void testInsert() {
        linkedList.addFirst(value3);
        linkedList.addFirst(value2);
        linkedList.addFirst(value1);
        linkedList.insert(1, value4);
        assertEquals((Integer) value1, linkedList.get(0));
        assertEquals((Integer) value4, linkedList.get(1));
        assertEquals((Integer) value2, linkedList.get(2));
        assertEquals((Integer) value3, linkedList.get(3));
    }

    @Test
    public void testDeleteWithFourValues() {
        linkedList.addFirst(value4);
        linkedList.addFirst(value3);
        linkedList.addFirst(value2);
        linkedList.addFirst(value1);
        linkedList.delete(1);
        assertEquals((Integer) value1, linkedList.get(0));
        assertEquals((Integer) value3, linkedList.get(1));
        assertEquals((Integer) value4, linkedList.get(2));
    }

    @Test
    public void testToString() {
        linkedList.addFirst(value4);
        linkedList.addFirst(value3);
        linkedList.addFirst(value2);
        linkedList.addFirst(value1);
        String toString = "item 0: 1\n" + "item 1: 2\n" + "item 2: 3\n" + "item 3: 4\n";

        assertEquals(toString, linkedList.toString());
    }

    @Test
    public void testRemoveFirstWithNoValues() {
        linkedList.removeFirst();
    }

    @Test
    public void testRemoveFirstWithOneValues() {
        linkedList.addFirst(value1);
        linkedList.removeFirst();
    }

    @Test
    public void testRemoveFirst() {
        linkedList.addFirst(value1);
        linkedList.addFirst(value2);
        linkedList.removeFirst();
        assertEquals((Integer) value1, linkedList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithSecondPlaceEmptyList() {
        linkedList.insert(1, value1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteSecondPlaceEmptyList() {
        linkedList.delete(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSecondPlaceEmptyList() {
        linkedList.get(1);
    }

    @Test
    public void testDeleteSecondplaceWithTwoItemsInList() {
        linkedList.addFirst(value1);
        linkedList.addFirst(value2);
        linkedList.delete(1);
    }
}