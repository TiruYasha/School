package Recursion.Faculteit;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RecursieTest {

    @Test
    public void faculteitReturns1When0() {
        int result = Recursion.faculteit(0);

        assertEquals(1, result);
    }

    @Test
    public void faculteitReturns1When1(){
        int result = Recursion.faculteit(1);

        assertEquals(1, result);
    }

    @Test
    public void faculteitReturns24When4(){
        int result = Recursion.faculteit(4);

        assertEquals(24, result);
    }

    @Test
    public void sumReturns0When0() {
        int result = Recursion.sum(0);

        assertEquals(0, result);
    }

    @Test
    public void sumReturns1When1(){
        int result = Recursion.sum(1);

        assertEquals(1, result);
    }

    @Test
    public void faculteitReturns15When5(){
        int result = Recursion.sum(5);

        assertEquals(15, result);
    }
}
