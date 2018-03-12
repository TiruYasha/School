package les3sorting;

public class InsertionSort<AnyType extends Comparable<? super AnyType>> implements ISortAlgorithm<AnyType> {

    @Override
    public AnyType[] sort(AnyType[] array) {
        for(int p = 1; p < array.length; p++) {
            AnyType tmp = array[p];
            int j = p;

            for(; j > 0 && tmp.compareTo( array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = tmp;
        }
        return array;
    }
}
