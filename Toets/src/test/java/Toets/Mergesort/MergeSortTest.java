package Toets.Mergesort;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {


    @Test
    public void mergeSortNonRecursive(){
        int[] arrayToSort = {2, 4, 8, 42, 12, 1, 18, 33};
        Integer[] sortedArray = {1, 2, 4, 8, 12, 18, 33, 42};

        Integer[] result =  MergeSort.mergeSort(IntStream.of(arrayToSort).boxed().toArray(Integer[]::new));

        assertArrayEquals(sortedArray, result);
    }
}
