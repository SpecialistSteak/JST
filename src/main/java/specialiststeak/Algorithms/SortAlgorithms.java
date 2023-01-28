package specialiststeak.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static specialiststeak.Algorithms.Shuffle.shuffle;

public class SortAlgorithms {

    /**
     * Tests all the sorting algorithms. This is used for testing and benchmarking on the same data.
     *
     * @param array The array to test on.
     * @param <T>   The type of the array.
     */
    public static <T extends Comparable<T>> SortTimeTester testAll(T[] array) {
        SortTimeTester timeTester = new SortTimeTester();

        timeTester.startTimer("Iterative bubble sort");
        iterativeBubbleSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Arrays.sort");
        ArraysSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard quick sort");
        quickSort(array, 0, array.length - 1);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard heap sort");
        heapSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard merge sort");
        mergeSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard insertion sort");
        insertionSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("HashMap sort");
        hashMapSort(array);
        timeTester.stopTimer();

        System.out.print(timeTester.toString());
        return timeTester;
    }

    /**
     * NOT Recommended for primitive types! Just use Arrays.sort() instead for those without generics.
     *
     * @param array The array to sort.
     * @param <T>   The type of the array.
     */
    public static <T extends Comparable<T>> void ArraysSort(T[] array) {
        Arrays.sort(array);
    }

    /**
     * Not the best bucket sort algorithm, since it runs in O(n+K) time, where K is the number of buckets.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void hashMapSort(T[] arr) {
        HashMap<T, List<T>> buckets = new HashMap<>();
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
    }

    /**
     * Quick sort algorithm.
     *
     * @param array The array to sort.
     * @param low   The lowest index to sort.
     * @param high  The highest index to sort.
     * @param <T>   The type of the array.
     */
    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * Quick sort helper method.
     *
     * @param array The array to sort.
     * @param low   The lowest index to sort.
     * @param high  The highest index to sort.
     * @param <T>   The type of the array.
     * @return The pivot index.
     */
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (array[i].compareTo(pivot) < 0);

            do {
                j--;
            } while (array[j].compareTo(pivot) > 0);

            if (i >= j) {
                return j;
            }

            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * Heap sort algorithm.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    /**
     * Heap sort helper method.
     *
     * @param arr The array to sort.
     * @param n   The length of the array.
     * @param i   The index to start at.
     * @param <T> The type of the array.
     */
    private static <T extends Comparable<T>> void heapify(T[] arr, int n, int i) {
        int MAX = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].compareTo(arr[MAX]) > 0) {
            MAX = left;
        }

        if (right < n && arr[right].compareTo(arr[MAX]) > 0) {
            MAX = right;
        }

        if (MAX != i) {
            swap(arr, i, MAX);
            heapify(arr, n, MAX);
        }
    }

    /**
     * Merge sort algorithm.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            T[] left = Arrays.copyOfRange(arr, 0, mid);
            T[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    /**
     * Merge sort helper method.
     *
     * @param arr   The array to sort.
     * @param left  The left array.
     * @param right The right array.
     * @param <T>   The type of the array.
     */
    private static <T extends Comparable<T>> void merge(T[] arr, T[] left, T[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mainIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) <= 0) {
                arr[mainIndex] = left[leftIndex];
                leftIndex++;
            } else {
                arr[mainIndex] = right[rightIndex];
                rightIndex++;
            }
            mainIndex++;
        }
        while (leftIndex < left.length) {
            arr[mainIndex] = left[leftIndex];
            leftIndex++;
            mainIndex++;
        }
        while (rightIndex < right.length) {
            arr[mainIndex] = right[rightIndex];
            rightIndex++;
            mainIndex++;
        }
    }

    /**
     * Insertion sort algorithm.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            var key = arr[j];
            int i = j - 1;
            while ((i > -1) && (arr[i].compareTo(key) > 0)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    /**
     * Iterative bubble sort algorithm.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void iterativeBubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param arr The array to swap elements in.
     * @param i   The first index.
     * @param j   The second index.
     * @param <T> The type of the array.
     */
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
