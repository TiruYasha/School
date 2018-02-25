package Sort.Sorting;

public class MergeSort {

    public static int[] sort(int[] arrayToSort) {
        int[] tmpArray = new int[arrayToSort.length];
        sort(arrayToSort, tmpArray, 0, arrayToSort.length - 1);

        return arrayToSort;
    }

    private static void sort(int[] arrayToSort, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            sort(arrayToSort, tmpArray, left, center);
            sort(arrayToSort, tmpArray, center + 1, right);
            merge(arrayToSort, tmpArray, left, center + 1, right);
        }
    }

    private static void merge(int[] arrayToSort, int[] tmpArray, int left, int rightPos, int rightEnd) {
        merge(arrayToSort, tmpArray, left, rightPos - 1, rightEnd, left, rightPos, left);
    }

    private static void merge(int[] arrayToSort,
                              int[] tmpArray,
                              int left,
                              int leftEnd,
                              int rightEnd,
                              int leftIndex,
                              int rightIndex,
                              int tmpArrayIndex) {

        if(tmpArrayIndex> rightEnd){
            tmpArrayToSortedArray(arrayToSort, tmpArray, left, rightEnd);

            return;
        }

        if (leftIndex > leftEnd) {
            tmpArray[tmpArrayIndex] = arrayToSort[rightIndex];
            merge(arrayToSort, tmpArray, left, leftEnd, rightEnd, leftIndex, rightIndex + 1, tmpArrayIndex + 1);
        }
        else if (rightIndex > rightEnd || arrayToSort[leftIndex] < arrayToSort[rightIndex]) {
            tmpArray[tmpArrayIndex] = arrayToSort[leftIndex];
            merge(arrayToSort, tmpArray, left, leftEnd, rightEnd, leftIndex + 1, rightIndex, tmpArrayIndex + 1);
        }
        else {
            tmpArray[tmpArrayIndex] = arrayToSort[rightIndex];
            merge(arrayToSort, tmpArray, left, leftEnd, rightEnd, leftIndex, rightIndex + 1, tmpArrayIndex + 1);
        }
    }

    private static void tmpArrayToSortedArray(int[] arrayToSort, int[] tmpArray, int left, int end) {
        for (int i = left; i < end + 1; i++) {
            arrayToSort[i] = tmpArray[i];
        }
    }
}
