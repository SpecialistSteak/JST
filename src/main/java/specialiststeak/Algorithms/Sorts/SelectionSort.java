package specialiststeak.Algorithms.Sorts;

import static specialiststeak.Algorithms.Sorts.SortUtils.swap;

public class SelectionSort implements SortAlgorithm {

    /**
     * Generic selection sort algorithm in increasing order.
     *
     * @param arr the array to be sorted.
     * @param <T> the class of array.
     * @return sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        return arr;
    }
}
