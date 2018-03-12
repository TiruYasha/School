package Lists.Stack.Queues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HANStackTest {

    private HANStack<Integer> sut;

    @Before
    public void initialize() {
        sut = new HANStack<>();
    }

    @Test
    public void pushAddsValueToTop() {
        sut.push(1);
        sut.push(2);

        Integer result = sut.stack.get(0);

        assertEquals(result, new Integer(2));
    }

    @Test
    public void topReturnsLatestValue() {
        sut.push(1);
        sut.push(2);

        Integer result = sut.top();

        assertEquals(result, new Integer(2));
    }

    @Test
    public void popReturnsLatestValueAndRemovesIt(){
        sut.push(1);
        sut.push(2);

        Integer result = sut.pop();
        Integer result2 = sut.top();

        assertEquals(result, new Integer(2));
        assertEquals(result2, new Integer(1));
    }

    @Test
    public void getSizeReturnsCorrectSize(){
        sut.push(1);
        sut.push(2);

        int result = sut.getSize();

        assertEquals(result, 2);
    }

}
