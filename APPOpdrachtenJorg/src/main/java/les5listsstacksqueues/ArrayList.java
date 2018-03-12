package les5listsstacksqueues;


import java.util.Arrays;

public class ArrayList<AnyType> {

    private int arrayLengthUsed;
    private AnyType[] array;

    public ArrayList() {
        arrayLengthUsed = 0;
        array = (AnyType[]) new Object[1];
    }

    public void add(AnyType value) {
        if(arrayLengthUsed >= array.length) {
            array = Arrays.copyOf(array, array.length * 2 + 1);
        }
        array[arrayLengthUsed] = value;
        arrayLengthUsed++;
    }

    public AnyType get(int index) {
        if(index >= arrayLengthUsed) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void set(int index, AnyType value) {
        if(index >= arrayLengthUsed) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    public String toString() {
        String value = "";
        for (int i = 0; i < arrayLengthUsed; i++) {
            value += "item " + i + ": " + get(i) + "\n";
        }
        return value;
    }
}
