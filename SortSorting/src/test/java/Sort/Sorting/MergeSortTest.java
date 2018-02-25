package Sort.Sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void mergeSortReturnsArray() {
        int[] arrayToSort = {1};

        int[] result = MergeSort.sort(arrayToSort);

        assertArrayEquals(arrayToSort, result);
    }

    @Test
    public void mergeSortReturnsSortedArray() {
        int[] arrayToSort = {4, 3, 7, 3, 2, 1, 3, 9, 7, 5};
        int[] sortedArray = {1, 2, 3, 3, 3, 4, 5, 7, 7, 9};

        int[] result = MergeSort.sort(arrayToSort);

        assertArrayEquals(sortedArray, result);
    }
}
