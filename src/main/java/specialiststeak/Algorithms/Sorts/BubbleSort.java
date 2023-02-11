package specialiststeak.Algorithms.Sorts;

import static specialiststeak.Algorithms.Sorts.SortUtils.greater;
import static specialiststeak.Algorithms.Sorts.SortUtils.swap;

/**
 * @author Varun Upadhyay (<a href="https://github.com/varunu28">...</a>)
 * @author Podshivalov Nikita (<a href="https://github.com/nikitap492">...</a>)
 */
public class BubbleSort implements SortAlgorithm {

    /**
     * Implements generic bubble sort algorithm.
     *
     * @param array the array to be sorted.
     * @param <T> the type of elements in the array.
     * @return the sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 1, size = array.length; i < size; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
