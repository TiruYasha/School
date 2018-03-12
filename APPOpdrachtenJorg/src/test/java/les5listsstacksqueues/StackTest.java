package les5listsstacksqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private static Stack<Integer> stack;

    private final static int value1 = 1;
    private final static int value2 = 2;

    @Before
    public void initialize() {
        stack = new Stack<>();
    }

    @Test
    public void testOnePush() throws Exception {
        stack.push(value1);
        assertEquals((Integer) value1, stack.top());
    }
    @Test
    public void testTwoPushs() throws Exception {
        stack.push(value1);
        stack.push(value2);
        assertEquals((Integer) value2, stack.top());
        stack.pop();
        assertEquals((Integer) value1, stack.top());
    }

    @Test
    public void getSize() throws Exception {
        stack.push(value1);
        stack.push(value2);
        assertEquals(2, stack.getSize());
    }

}