package specialiststeak.Algorithms.Sorts;

import java.util.Arrays;

public class ArraysSort implements SortAlgorithm {

    /**
     * NOT Recommended for primitive types! Just use Arrays.sort() instead for those without generics.
     *
     * @param array The array to sort.
     * @param <T>   The type of the array.
     */
    public <T extends Comparable<T>> T[] sort(T[] array) {
        Arrays.sort(array);
        return array;
    }
}
