package specialiststeak.Algorithms.Sorts;

/**
 * Lame Sort Algorithm Implementation
 *
 * @author SpecialistSteak
 */
public class LameSort implements SortAlgorithm {
    private static final int SMALL = 10;
    private static final int MEDIUM = 10000;
    private static final int LARGE = -1;

    public static <T extends Comparable<T>> int getRange(T[] array) {
        if (array.length < SMALL) {
            return SMALL;
        } else if (array.length < MEDIUM) {
            return MEDIUM;
        } else {
            return LARGE;
        }
    }

    public <T extends Comparable<T>> T[] sort(T[] array) {
        switch (getRange(array)) {
            case SMALL -> {
                new InsertionSort().sort(array);
            }
            case MEDIUM -> {
                new HeapSort().sort(array);
            }
            case LARGE -> {
                new DualPivotQuickSort().sort(array);
            }
        }
        return array;
    }
}