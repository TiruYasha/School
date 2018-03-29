package Toets.Mergesort;

public class MergeSort {
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
            isSorted(a, left, right);

            if (!isSorted(a, left, right)) {
                mergeRight(a, tmpArray, center, right, left);
            }
        }
    }

    private static <AnyType extends Comparable<? super AnyType>> boolean isSorted(AnyType[] a, int left, int right) {
        for (int i = left; i < right; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void mergeRight(AnyType[] a, AnyType[] tmpArray,
                    int leftPos, int rightPos, int leftEnd) {
        int rightEnd = leftPos + 1;
        int tmpPos = rightPos;
        int numElements = rightPos - leftEnd + 1;

        // Main loop
        while (rightPos >= rightEnd && leftPos >= leftEnd) {
            if (a[rightPos].compareTo(a[leftPos]) >= 0) {
                tmpArray[tmpPos--] = a[rightPos--];
            } else {
                tmpArray[tmpPos--] = a[leftPos--];
            }
        }

        while (rightPos >= rightEnd) // Copy rest of right half
        {
            tmpArray[tmpPos--] = a[rightPos--];
        }

        while (leftPos >= leftEnd) // Copy rest of first half
        {
            tmpArray[tmpPos--] = a[leftPos--];
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, leftEnd++) {
            a[leftEnd] = tmpArray[leftEnd];
        }
    }
}



