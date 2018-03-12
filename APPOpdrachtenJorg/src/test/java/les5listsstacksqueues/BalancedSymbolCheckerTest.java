package les5listsstacksqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedSymbolCheckerTest {

    private static final String[] array = {"[", "(", "{", "}", ")", "]"};
    private static final BalancedSymbolChecker balancedSymbolChecker = new BalancedSymbolChecker();

    @Test(expected = AssertionError.class)
    public void checkSymbols() throws Exception {
        assertTrue(balancedSymbolChecker.checkSymbols(array));
    }

}