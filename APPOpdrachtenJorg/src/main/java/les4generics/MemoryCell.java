package les4generics;

public class MemoryCell<AnyType extends Comparable<? super AnyType>> implements Comparable<MemoryCell<AnyType>> {

    private AnyType storedValue;

    public AnyType read() {
        return storedValue;
    }

    public void write(AnyType x) {
        storedValue = x;
    }

    @Override
    public int compareTo(MemoryCell<AnyType> o) {
        return this.read().compareTo(o.read());
    }
}