package specialiststeak.Algorithms;

import specialiststeak.TimeUtils.Times;

import java.util.*;

import static specialiststeak.Algorithms.Shuffle.shuffle;

public class SortAlgorithms {

    //TODO: Add the other sorting algorithms to the testAll method.

    /**
     * Tests all the sorting algorithms. This is used for testing and benchmarking on the same data.
     *
     * @param array The array to test on.
     * @param <T>   The type of the array.
     */
    public static <T extends Comparable<T>> SortTimeTester testAll(T[] array) {
        SortTimeTester timeTester = new SortTimeTester();

        shuffle(array);

        timeTester.startTimer("Iterative bubble sort");
        iterativeBubbleSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Recursive bubble sort");
        recursiveBubbleSort(array, array.length);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Comb sort");
        combSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard selection sort");
        selectionSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard insertion sort");
        insertionSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard gnome sort");
        gnomeSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Shell sort");
        shellSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard merge sort");
        mergeSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard heap sort");
        heapSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Standard quick sort");
        quickSort(array, 0, array.length - 1);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Dual pivot quick sort");
        dualPivotQuickSort(array, 0, array.length - 1);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Tri pivot quick sort");
        triPivotQuickSort(array, 0, array.length - 1);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("HashMap sort");
        hashMapSort(array);
        timeTester.stopTimer();

        shuffle(array);

        timeTester.startTimer("Arrays.sort");
        ArraysSort(array);
        timeTester.stopTimer();

        shuffle(array);

        List<T> list = Arrays.asList(array);
        timeTester.startTimer("Collections.sort");
        Collections.sort(list);
        timeTester.stopTimer();

        ArrayList<SortTimes> l = timeTester.getTimes();
        SortTimes[] arr = l.toArray(new SortTimes[0]);
        insertionSort(arr);
        l = new ArrayList<>(Arrays.asList(arr));
        timeTester.setTimes(l);

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
     * This is an adapted version of the bucket sort algorithm.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void hashMapSort(T[] arr) {
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
    }

    /**
     * Single pivot quick sort algorithm.
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
     * Single pivot quick sort helper method.
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

    /**
     * Recursive bubble sort algorithm.
     *
     * @param arr The array to sort.
     * @param n   The length of the array.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void recursiveBubbleSort(T[] arr, int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                swap(arr, i, i + 1);
            }
        }
        recursiveBubbleSort(arr, n - 1);
    }

    /**
     * Selection sort algorithm.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    /**
     * Shell sort algorithm.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap].compareTo(temp) > 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * Comb sort algorithm's helper method to get the next gap.
     *
     * @param gap The gap to use.
     * @return The next gap.
     */
    public static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }

    /**
     * Comb sort algorithm.
     *
     * @param arr The array to sort.
     * @param <T> The type of the array.
     */
    public static <T extends Comparable<T>> void combSort(T[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (arr[i].compareTo(arr[i + gap]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    /**
     * Dual pivot quick sort algorithm.
     *
     * @param array The array to sort.
     * @param low   The lowest index to sort.
     * @param high  The highest index to sort.
     * @param <T>   The type of the array.
     */
    public static <T extends Comparable<T>> void dualPivotQuickSort(T[] array, int low, int high) {
        if (low < high) {
            int[] pivotIndices = partitionDualPivot(array, low, high);
            dualPivotQuickSort(array, low, pivotIndices[0] - 1);
            dualPivotQuickSort(array, pivotIndices[0] + 1, pivotIndices[1] - 1);
            dualPivotQuickSort(array, pivotIndices[1] + 1, high);
        }
    }

    /**
     * Dual pivot quick sort helper method.
     *
     * @param array The array to sort.
     * @param low   The lowest index to sort.
     * @param high  The highest index to sort.
     * @param <T>   The type of the array.
     * @return The pivot indices.
     */
    private static <T extends Comparable<T>> int[] partitionDualPivot(T[] array, int low, int high) {
        if (array[low].compareTo(array[high]) > 0) {
            T temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }

        T pivot1 = array[low];
        T pivot2 = array[high];
        int i = low + 1;
        int lt = low + 1;
        int gt = high - 1;

        while (i <= gt) {
            int cmp1 = array[i].compareTo(pivot1);
            if (cmp1 < 0) {
                T temp = array[i];
                array[i] = array[lt];
                array[lt] = temp;
                lt++;
                i++;
            } else if (cmp1 > 0) {
                int cmp2 = array[i].compareTo(pivot2);
                if (cmp2 > 0) {
                    T temp = array[i];
                    array[i] = array[gt];
                    array[gt] = temp;
                    gt--;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        lt--;
        gt++;

        T temp = array[low];
        array[low] = array[lt];
        array[lt] = temp;

        temp = array[high];
        array[high] = array[gt];
        array[gt] = temp;

        return new int[]{lt, gt};
    }

    /**
     * Three pivot quick sort algorithm.
     *
     * @param array The array to sort.
     * @param low   The lowest index to sort.
     * @param high  The highest index to sort.
     * @param <T>   The type of the array.
     */
    public static <T extends Comparable<T>> void triPivotQuickSort(T[] array, int low, int high) {
        if (low < high) {
            int[] pivotIndices = partitionThreePivot(array, low, high);
            triPivotQuickSort(array, low, pivotIndices[0] - 1);
            triPivotQuickSort(array, pivotIndices[0] + 1, pivotIndices[1] - 1);
            triPivotQuickSort(array, pivotIndices[1] + 1, pivotIndices[2] - 1);
            triPivotQuickSort(array, pivotIndices[2] + 1, high);
        }
    }

    /**
     * Three pivot quick sort helper method.
     *
     * @param array The array to sort.
     * @param low   The lowest index to sort.
     * @param high  The highest index to sort.
     * @param <T>   The type of the array.
     * @return The pivot indices.
     */
    private static <T extends Comparable<T>> int[] partitionThreePivot(T[] array, int low, int high) {
        T pivot1 = array[low];
        T pivot2 = array[low + (high - low) / 2];
        T pivot3 = array[high];

        if (pivot1.compareTo(pivot2) > 0) {
            T temp = pivot1;
            pivot1 = pivot2;
            pivot2 = temp;
        }

        if (pivot2.compareTo(pivot3) > 0) {
            if (pivot1.compareTo(pivot3) > 0) {
                T temp = pivot1;
                pivot1 = pivot3;
                pivot3 = pivot2;
                pivot2 = temp;
            } else {
                T temp = pivot2;
                pivot2 = pivot3;
                pivot3 = temp;
            }
        }

        int i = low + 1;
        int lt = low + 1;
        int gt = high - 1;

        while (i <= gt) {
            int cmp1 = array[i].compareTo(pivot1);
            if (cmp1 < 0) {
                T temp = array[i];
                array[i] = array[lt];
                array[lt] = temp;
                lt++;
                i++;
            } else if (cmp1 > 0) {
                int cmp3 = array[i].compareTo(pivot3);
                if (cmp3 > 0) {
                    T temp = array[i];
                    array[i] = array[gt];
                    array[gt] = temp;
                    gt--;
                } else {
                    int cmp2 = array[i].compareTo(pivot2);
                    if (cmp2 > 0) {
                        T temp = array[i];
                        array[i] = array[gt];
                        array[gt] = temp;
                        gt--;
                    } else {
                        i++;
                    }
                }
            } else {
                i++;
            }
        }

        lt--;
        gt++;

        T temp = array[low];
        array[low] = array[lt];
        array[lt] = temp;
        return new int[]{lt, gt, high};
    }

    /**
     * Gnome sort.
     *
     * @param array The array to sort.
     * @param <T>   The type of the array.
     */
    public static <T extends Comparable<T>> void gnomeSort(T[] array) {
        int i = 1;
        int j = 2;
        while (i < array.length) {
            if (array[i - 1].compareTo(array[i]) <= 0) {
                i = j;
                j++;
            } else {
                T temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;
                i--;
                if (i == 0) {
                    i = j;
                    j++;
                }
            }
        }
    }
}