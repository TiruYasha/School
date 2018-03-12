package Sort.Sorting;

public class MergeSort {


    public static int[] sortRecursive(int[] arrayToSort) {
        int[] tmpArray = new int[arrayToSort.length];
        sortRecursive(arrayToSort, tmpArray, 0, arrayToSort.length - 1);

        return arrayToSort;
    }

    private static void sortRecursive(int[] arrayToSort, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            sortRecursive(arrayToSort, tmpArray, left, center);
            sortRecursive(arrayToSort, tmpArray, center + 1, right);
            mergeRecursive(arrayToSort, tmpArray, left, center + 1, right);
        }
    }

    private static void mergeRecursive(int[] arrayToSort, int[] tmpArray, int left, int rightPos, int rightEnd) {
        mergeRecursive(arrayToSort, tmpArray, left, rightPos - 1, rightEnd, left, rightPos, left);
    }

    private static void mergeRecursive(int[] arrayToSort,
                                       int[] tmpArray,
                                       int left,
                                       int leftEnd,
                                       int rightEnd,
                                       int leftIndex,
                                       int rightIndex,
                                       int tmpArrayIndex) {

        if (tmpArrayIndex > rightEnd) {
            tmpArrayToSortedArray(arrayToSort, tmpArray, left, rightEnd);

            return;
        }

        if (leftIndex > leftEnd) {
            tmpArray[tmpArrayIndex] = arrayToSort[rightIndex];
            mergeRecursive(arrayToSort,
                    tmpArray,
                    left,
                    leftEnd,
                    rightEnd,
                    leftIndex,
                    rightIndex + 1,
                    tmpArrayIndex + 1);
        }
        else if (rightIndex > rightEnd || arrayToSort[leftIndex] < arrayToSort[rightIndex]) {
            tmpArray[tmpArrayIndex] = arrayToSort[leftIndex];
            mergeRecursive(arrayToSort,
                    tmpArray,
                    left,
                    leftEnd,
                    rightEnd,
                    leftIndex + 1,
                    rightIndex,
                    tmpArrayIndex + 1);
        }
        else {
            tmpArray[tmpArrayIndex] = arrayToSort[rightIndex];
            mergeRecursive(arrayToSort,
                    tmpArray,
                    left,
                    leftEnd,
                    rightEnd,
                    leftIndex,
                    rightIndex + 1,
                    tmpArrayIndex + 1);
        }
    }

    private static void tmpArrayToSortedArray(int[] arrayToSort, int[] tmpArray, int left, int end) {
        for (int i = left; i < end + 1; i++) {
            arrayToSort[i] = tmpArray[i];
        }
    }


    public static <AnyType extends Comparable<? super AnyType>> AnyType[] mergeSort(AnyType[] a) {
        AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);

        return a;
    }

    /**
     * 13 * Internal method that makes recursive calls.
     * 14 * @param a an array of Comparable items.
     * 15 * @param tmpArray an array to place the merged result.
     * 16 * @param left the left-most index of the subarray.
     * 17 * @param right the right-most index of the subarray.
     * 18
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] a, AnyType[] tmpArray,
                   int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void merge(AnyType[] a, AnyType[] tmpArray,
               int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            }
            else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) // Copy rest of first half
        {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) // Copy rest of right half
        {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

}



