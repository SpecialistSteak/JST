package specialiststeak.Algorithms.Sorts;

/**
 * BubbleSort algorithm implements using recursion
 */
public class BubbleSortRecursion implements SortAlgorithm {

    /**
     * @param unsorted - an array should be sorted
     * @return sorted array
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        bubbleSort(unsorted, unsorted.length);
        return unsorted;
    }

    /**
     * BubbleSort algorithm implements using recursion
     *
     * @param unsorted array contains elements
     * @param len length of given array
     */
    private static <T extends Comparable<T>> void bubbleSort(
        T[] unsorted,
        int len
    ) {
        boolean swapped = false;
        /* flag to check if array is sorted or not */
        for (int i = 0; i < len - 1; ++i) {
            if (SortUtils.greater(unsorted[i], unsorted[i + 1])) {
                SortUtils.swap(unsorted, i, i + 1);
                swapped = true;
            }
        }
        if (swapped) {
            bubbleSort(unsorted, len - 1);
        }
    }
}
