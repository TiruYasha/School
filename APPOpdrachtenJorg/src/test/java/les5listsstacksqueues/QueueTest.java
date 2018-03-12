package les5listsstacksqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private static Queue<Integer> queue;
    private static final int number1 = 1;
    private static final int number2 = 2;
    private static final int number3 = 3;

    @Before
    public void initialize() throws Exception {
        queue = new Queue<>();
    }

    @Test
    public void testOneItem() {
        queue.enqueue(number1);
        assertEquals((Integer)number1, queue.getFront());
    }

    @Test
    public void testTwoItem() {
        queue.enqueue(number1);
        queue.enqueue(number2);
        assertEquals((Integer)number1, queue.dequeue());
        assertEquals((Integer)number2, queue.dequeue());
    }

    @Test
    public void testThreeItem() {
        queue.enqueue(number1);
        queue.enqueue(number2);
        queue.enqueue(number3);
        assertEquals((Integer)number1, queue.dequeue());
        assertEquals((Integer)number2, queue.dequeue());
        assertEquals((Integer)number3, queue.dequeue());
    }



}