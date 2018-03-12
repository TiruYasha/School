package les3sorting;

import les4generics.MemoryCell;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestSortAlgorithm {

    private static ISortAlgorithm[] sortAlgorithms;

    private final static int ARRAY_LONG = 1000;

    private final static int[] randomOrder = {8, 1, 4, 1, 5, 9, 2, 6, 5};
    private final static int[] awnser = {1, 1, 2, 4, 5, 5, 6, 8, 9};
    private final static int[] empty = {};
    private final static int[] reverseOrder = {9, 8, 6, 5, 5, 4, 2, 1, 1};
    private final static int[] sameNumbers = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

    private static int[] randomOrderLong = new int[ARRAY_LONG];
    private static int[] awnserLong = new int[ARRAY_LONG];

    private final static String[] awnserString = {"A","B","C","D","E","F","G","H","I"};
    private final static String[] randomOrderString = {"H","F","D","I","C","B","G","A","E"};

    private static MemoryCell[] awnserMemoryCell;
    private static MemoryCell[] randomOrderMemoryCell;

    @BeforeClass
    public static void setup() {
        generateRandomOrderLongAndAwnserLong();
        createTestInstances();
        createMemoryCells();
    }

    private static void createMemoryCells() {
        awnserMemoryCell = new MemoryCell[awnserString.length];
        randomOrderMemoryCell = new MemoryCell[randomOrderString.length];
        for (int i = 0; i < awnserMemoryCell.length; i++) {
            awnserMemoryCell[i] = new MemoryCell();
            awnserMemoryCell[i].write(awnserString[i]);
            randomOrderMemoryCell[i] = new MemoryCell();
            randomOrderMemoryCell[i].write(randomOrderString[i]);
        }
    }

    private static void createTestInstances() {
        sortAlgorithms = new ISortAlgorithm[4];
        sortAlgorithms[0] = new BubbleSort();
        sortAlgorithms[1] = new InsertionSort();
        sortAlgorithms[2] = new MergeSort();
        sortAlgorithms[3] = new QuickSort();
    }

    private static void generateRandomOrderLongAndAwnserLong() {
        Random r = new Random();

        for (int i = 0; i < ARRAY_LONG; i++) {
            awnserLong[i] = i;
            randomOrderLong[i] = i;
        }

        for (int i = ARRAY_LONG - 1; i > 0; i--) {
            int index = r.nextInt(i + 1);
            int a = randomOrderLong[index];
            randomOrderLong[index] = randomOrderLong[i];
            randomOrderLong[i] = a;
        }
    }

    private void compare(int[] awnser, int[] input) {
        Integer[] integerAwnser = Arrays.stream( awnser ).boxed().toArray( Integer[]::new );
        Integer[] integerInput = Arrays.stream( input ).boxed().toArray( Integer[]::new );
        compare(integerAwnser, integerInput);
    }

    private void compare(Comparable[] awnser, Comparable[] input) {
        for (int i = 0; i < sortAlgorithms.length; i++) {
            assertArrayEquals(awnser, sortAlgorithms[i].sort(input));
        }
    }

    private void compareMemoryCell(MemoryCell[] awnser, MemoryCell[] input) {
        for (int i = 0; i < sortAlgorithms.length; i++) {
            MemoryCell[] inputOrdered = (MemoryCell[]) sortAlgorithms[i].sort(input);
            for (int j = 0; j < awnser.length; j++) {
                assertEquals(awnser[j].read(), inputOrdered[j].read());
            }
        }
    }

    @Test
    public void testRandomOrder() {
        compare(awnser, randomOrder);
    }

    @Test
    public void testSameInput() {
        compare(awnser, awnser);
    }

    @Test
    public void testEmpty() {
        compare(empty, empty);
    }

    @Test
    public void testReverseOrder() {
        compare(awnser, reverseOrder);
    }

    @Test
    public void testRandomOrderLong() {
       compare(awnserLong, randomOrderLong);
    }

    @Test
    public void testSameNumbers() {
        compare(sameNumbers, sameNumbers);
    }

    @Test
    public void testRandomOrderString() {
        compare(awnserString, randomOrderString);
    }

    @Test
    public void testRandomOrderMemoryCell() {
        compareMemoryCell(awnserMemoryCell, randomOrderMemoryCell);
    }
}
