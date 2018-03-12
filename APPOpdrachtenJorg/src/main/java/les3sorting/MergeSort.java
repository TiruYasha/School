package les3sorting;

public class MergeSort<AnyType extends Comparable<? super AnyType>> implements ISortAlgorithm<AnyType> {

    @Override
    public AnyType[] sort(AnyType[] array) {
        AnyType[] tmpArray = (AnyType[]) new Comparable[array.length];
        sort(array, tmpArray, 0, array.length - 1);
        return array;
    }

    private void sort(Comparable[] array, Comparable[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            sort(array, tmpArray, left, center);
            sort(array, tmpArray, center + 1, right);
            merge(array, tmpArray, left, center + 1, right);
        }
    }

    private void merge(Comparable[] array, Comparable[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos].compareTo(array[rightPos]) <= 0) {
                tmpArray[tmpPos++] = array[leftPos++];
            } else {
                tmpArray[tmpPos++] = array[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = array[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = array[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = tmpArray[rightEnd];
        }
    }

// VAN DE LES
//        public static int[] merge (int[] a, int[] b){
//            int[] result = new int[a.length+b.length];
//
//            int i = 0;
//            int j = 0;
//            int index = 0;
//
//            while (i < a.length && j < b.length ){
//                if (a[i] <= b[j]){
//                    result[index] = a[i];
//                    i++;
//                } else {
//                    result[index] = b[j];
//                    j++;
//                }
//                index++;
//            }
//
//            while ( i<a.length){
//                result[index]=a[i];
//                i++;
//                index++;
//            }
//
//            while ( j<b.length){
//                result[index]=b[j];
//                j++;
//                index++;
//            }
//
//
//
//
//            return result;
//        }
}
