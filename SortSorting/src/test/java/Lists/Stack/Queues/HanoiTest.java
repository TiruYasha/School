package Lists.Stack.Queues;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HanoiTest {

    private Hanoi sut;

    @Before
    public void initialize() {
        sut = new Hanoi();
    }

    @Test
    public void hanoiPlacesIntToDestinationStick() {
        sut.hanoi(5);

        assertEquals(sut.destinationStack.getSize(), 5);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            result.add(sut.destinationStack.pop());
        }

        assertArrayEquals(result.toArray(), expected.toArray());

    }
}
