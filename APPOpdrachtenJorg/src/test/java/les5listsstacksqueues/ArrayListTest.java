package les5listsstacksqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    private static ArrayList arrayList;

    private static int number1 = 1;
    private static int number2 = 2;
    private static int number3 = 3;
    private static int number4 = 4;
    private static int number5 = 5;
    private static int number6 = 6;
    private static int number7 = 7;
    private static int number8 = 8;
    private static int number9 = 9;
    private static int number10 = 10;

    @Before
    public void initialize() {
        arrayList = new ArrayList();
    }

    @Test
    public void testOneNumber() throws Exception {
        arrayList.add(number1);
        assertEquals(number1, arrayList.get(0));
    }

    @Test
    public void testTwoNumbers() throws Exception {
        arrayList.add(number1);
        arrayList.add(number2);
        assertEquals(number1, arrayList.get(0));
        assertEquals(number2, arrayList.get(1));
    }

    @Test
    public void testTenNumbers() throws Exception {
        arrayList.add(number1);
        arrayList.add(number2);
        arrayList.add(number3);
        arrayList.add(number4);
        arrayList.add(number5);
        arrayList.add(number6);
        arrayList.add(number7);
        arrayList.add(number8);
        arrayList.add(number9);
        arrayList.add(number10);
        assertEquals(number1, arrayList.get(0));
        assertEquals(number2, arrayList.get(1));
        assertEquals(number3, arrayList.get(2));
        assertEquals(number4, arrayList.get(3));
        assertEquals(number5, arrayList.get(4));
        assertEquals(number6, arrayList.get(5));
        assertEquals(number7, arrayList.get(6));
        assertEquals(number8, arrayList.get(7));
        assertEquals(number9, arrayList.get(8));
        assertEquals(number10, arrayList.get(9));
    }

    @Test
    public void testSet() {
        arrayList.add(number1);
        arrayList.set(0, number2);
        assertEquals(number2, arrayList.get(0));
    }

    @Test
    public void testToString() {
        arrayList.add(number1);
        arrayList.add(number2);
        arrayList.add(number3);
        arrayList.add(number4);
        arrayList.add(number5);
        arrayList.add(number6);
        arrayList.add(number7);
        arrayList.add(number8);
        arrayList.add(number9);
        arrayList.add(number10);
        assertEquals("item 0: 1\n" +
                "item 1: 2\n" +
                "item 2: 3\n" +
                "item 3: 4\n" +
                "item 4: 5\n" +
                "item 5: 6\n" +
                "item 6: 7\n" +
                "item 7: 8\n" +
                "item 8: 9\n" +
                "item 9: 10\n", arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithWrongIndex() {
        arrayList.add(number1);
        arrayList.add(number2);
        arrayList.add(number3);
        arrayList.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithWrongIndex() {
        arrayList.add(number1);
        arrayList.add(number2);
        arrayList.add(number3);
        arrayList.set(3, number4);
    }
}