package specialiststeak.Algorithms.Sorts;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapSort implements SortAlgorithm {

    public <T extends Comparable<T>> T[] sort(T[] arr) {
        HashMap<T, ArrayList<T>> buckets = new HashMap<>();
        for (T element : arr) {
            if (!buckets.containsKey(element)) {
                buckets.put(element, new ArrayList<>());
            }
            buckets.get(element).add(element);
        }
        int currentIndex = 0;
        for (T key : buckets.keySet()) {
            for (T element : buckets.get(key)) {
                arr[currentIndex++] = element;
            }
        }
        return arr;
    }
}