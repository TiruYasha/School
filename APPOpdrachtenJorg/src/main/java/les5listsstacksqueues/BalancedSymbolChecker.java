package les5listsstacksqueues;

public class BalancedSymbolChecker {

    private static final String[] OPENING_SYMBOLS = {"[", "{", "("};
    private static final String[] CLOSING_SYMBOLS = {"]", "}", ")"};

    BalancedSymbolChecker() {

    }

    public boolean checkSymbols(String[] array) {
        Stack<String> stack = new Stack<>();
        int openingSymbolNumber = 0;
        //loop String array
        for (int i = 0; i < array.length; i++) {
            //loop symbols array
            for (int j = 0; j < OPENING_SYMBOLS.length; j++) {
                //check opening
                if (array[i].equals(OPENING_SYMBOLS[j])) {
                    stack.push(array[i]);
                    openingSymbolNumber = j;
                } else {
                    //check closing
                    if (array[i].equals(CLOSING_SYMBOLS[j])) {
                        //check empty
                        if (stack.getSize() == 0) {
                            return false;
                        } else {
                            //check opening == closing
                            if (j != openingSymbolNumber) {
                                return false;
                            } else {
                                //get new openingSymbol
                                for (int k = 0; k < OPENING_SYMBOLS.length; k++) {
                                    if (stack.top().equals(OPENING_SYMBOLS[k])) {
                                        openingSymbolNumber = k;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //check end empty
        if (stack.getSize() != 0) {
            return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        BSC test = new BSC("()Hallo()");
//        System.out.println(test.report());
//    }
//
//    MyStack.HANStack<Character> stack;
//
//    public BSC(String input) {
//
//        //remove all unusefull chars from string
//        String toTest = "";
//        for (char x : input.toCharArray()) {
//            if (x == '(' || x == ')') {
//                toTest += x;
//            }
//        }
//
//        stack = new MyStack.HANStack<Character>(toTest.length());
//
//        for (char x : toTest.toCharArray()) {
//            if (x == '(') {
//                stack.push(x);
//            } else {
//                if (stack.isEmpty()) {
//                    throw new NullPointerException();
//                }
//                stack.pop();
//            }
//        }
//    }
//
//    public boolean report() {
//        if (!stack.isEmpty()) {
//            throw new NullPointerException();
//        }
//        return true;
//    }
}
