package les5listsstacksqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TorensVanHanoiTest {

    private static TorensVanHanoi<Integer> torensVanHanoi;
    private Stack<Integer> stack;

    @Before
    public void initialize() throws Exception {
        torensVanHanoi = new TorensVanHanoi<>();
        stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void hanoi() throws Exception {
        System.out.println(torensVanHanoi.Hanoi(stack));
    }

}