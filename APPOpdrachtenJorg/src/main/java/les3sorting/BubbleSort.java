package les3sorting;

class BubbleSort<AnyType extends Comparable<? super AnyType>> implements ISortAlgorithm<AnyType> {

    @Override
    public AnyType[] sort(AnyType[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    //swap elements
                    AnyType temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}