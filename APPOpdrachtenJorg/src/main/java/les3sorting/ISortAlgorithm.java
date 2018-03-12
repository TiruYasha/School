package les3sorting;

public interface ISortAlgorithm <AnyType extends Comparable<? super AnyType>> {
    AnyType[] sort(AnyType[] array);
}
