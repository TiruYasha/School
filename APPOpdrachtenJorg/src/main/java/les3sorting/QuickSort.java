package les3sorting;

public class QuickSort<AnyType extends Comparable<? super AnyType>> implements ISortAlgorithm<AnyType> {

    private AnyType[] numbers;
    private int number;

    @Override
    public AnyType[] sort(AnyType[] array) {
        // check for empty or null array
        if (array == null || array.length == 0) {
            return array;
        }
        numbers = array;
        number = array.length;
        quicksort(0, number - 1);
        return numbers;
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        AnyType pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i].compareTo(pivot) < 0) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j].compareTo(pivot) > 0) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        AnyType temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}


//UIT BOEK, NIET GOED
//
//public class QuickSort implements ISortAlgorithm {
//
//    public int[] sort(int[] a) {
//        sort(a, 0, a.length - 1);
//        return a;
//    }
//
//    private void sort(int[] a, int low, int high) {
//        int middle = (low + high) / 2;
//        if (a[middle] < a[low]) {
//            swap(a, low, middle);
//        }
//        if (a[high] < a[low]) {
//            swap(a, low, high);
//        }
//        if (a[high] < a[middle]) {
//            swap(a, middle, high);
//        }
//
//        swap(a, middle, high - 1);
//        int pivot = a[high - 1];
//
//        int i, j;
//        for (i = low, j = high - 1; ; ) {
//            while (a[++i] < pivot)
//                ;
//            while (pivot < a[--j])
//                ;
//            if (i >= j) {
//                break;
//            }
//            swap(a, i, j);
//        }
//
//        swap(a, i, high - 1);
//
//        sort(a, low, i - 1);
//        sort(a, i + 1, high);
//    }
//
//    private static void swap(final int[] a, final int pos1, final int pos2) {
//        final int temp = a[pos1];
//        a[pos1] = a[pos2];
//        a[pos2] = temp;
//    }
//}
//
