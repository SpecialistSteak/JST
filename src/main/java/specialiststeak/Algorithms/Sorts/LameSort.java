package specialiststeak.Algorithms.Sorts;

/**
 * Lame Sort Algorithm Implementation
 *
 * @author SpecialistSteak
 */
public class LameSort implements SortAlgorithm {
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length < 50) {
            new InsertionSort().sort(array);
        } else if (array.length < 10_000) {
            new HeapSort().sort(array);
        } else {
            new DualPivotQuickSort().sort(array);
        }
        return array;
    }
}