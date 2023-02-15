package specialiststeak.Algorithms;

import specialiststeak.Algorithms.Sorts.*;

import java.util.ArrayList;
import java.util.Collections;

import static specialiststeak.Algorithms.Shuffle.shuffle;
import static specialiststeak.Algorithms.SortTimeTester.runCode;

public class SortAlgorithms {
    private static final String[] sortNames = {
        "Arrays.sort", "Bubble Sort", "Bubble Sort Recursive", "Circle Sort",
        "Cocktail Shaker Sort", "Comb Sort", "Counting Sort",
        "Cycle Sort", "Dual Pivot Quick Sort", "Dutch National Flag Sort",
        "Gnome Sort", "Hash Map Sort", "Heap Sort",
        "Insertion Sort", "Introspective Sort", "Lame Sort",
        "Merge Sort", "Pancake Sort", "Quick Sort",
        "Selection Sort", "Shell Sort", "Simple Sort",
        "Swap Sort", "Tim Sort", "Tree Sort",
        "Wiggle Sort"
    };

    public static <T extends Comparable<T>> void testAll(T[] array) {
        long[] arr = new long[sortNames.length];
        for (int i = 0; i < sortNames.length; i++) {
            shuffle(array);
            switch (i) {
                case 0 -> arr[0]   = runCode(() -> new ArraysSort().sort(array));
                case 1 -> arr[1]   = runCode(() -> new BubbleSort().sort(array));
                case 2 -> arr[2]   = runCode(() -> new BubbleSortRecursion().sort(array));
                case 3 -> arr[3]   = runCode(() -> new CircleSort().sort(array));
                case 4 -> arr[4]   = runCode(() -> new CocktailShakerSort().sort(array));
                case 5 -> arr[5]   = runCode(() -> new CombSort().sort(array));
                case 6 -> arr[6]   = runCode(() -> new CountingSort().sort(array));
                case 7 -> arr[7]   = runCode(() -> new CycleSort().sort(array));
                case 8 -> arr[8]   = runCode(() -> new DualPivotQuickSort().sort(array));
                case 9 -> arr[9]   = runCode(() -> new DutchNationalFlagSort().sort(array));
                case 10 -> arr[10] = runCode(() -> new GnomeSort().sort(array));
                case 11 -> arr[11] = runCode(() -> new HashMapSort().sort(array));
                case 12 -> arr[12] = runCode(() -> new HeapSort().sort(array));
                case 13 -> arr[13] = runCode(() -> new InsertionSort().sort(array));
                case 14 -> arr[14] = runCode(() -> new IntrospectiveSort().sort(array));
                case 15 -> arr[15] = runCode(() -> new LameSort().sort(array));
                case 16 -> arr[16] = runCode(() -> new MergeSort().sort(array));
                case 17 -> arr[17] = runCode(() -> new PancakeSort().sort(array));
                case 18 -> arr[18] = runCode(() -> new QuickSort().sort(array));
                case 19 -> arr[19] = runCode(() -> new SelectionSort().sort(array));
                case 20 -> arr[20] = runCode(() -> new ShellSort().sort(array));
                case 21 -> arr[21] = runCode(() -> new SimpleSort().sort(array));
                case 22 -> arr[22] = runCode(() -> new SwapSort().sort(array));
                case 23 -> arr[23] = runCode(() -> new TimSort().sort(array));
                case 24 -> arr[24] = runCode(() -> new TreeSort().sort(array));
                case 25 -> arr[25] = runCode(() -> new WiggleSort().sort(array));
            }
        }
        printResults(arr);
    }

    public static <T extends Comparable<T>> void testAll(T[] array, int iterations) {
        long[][] ar2r = new long[sortNames.length][iterations];
        long[] average = new long[sortNames.length];
        for (int i = 0; i < sortNames.length; i++) {
            shuffle(array);
            for (int j = 0; j < iterations; j++) {
                shuffle(array);
                switch (i) {
                    case 0 -> ar2r[0][j]   = runCode(() -> new ArraysSort().sort(array));
                    case 1 -> ar2r[1][j]   = runCode(() -> new BubbleSort().sort(array));
                    case 2 -> ar2r[2][j]   = runCode(() -> new BubbleSortRecursion().sort(array));
                    case 3 -> ar2r[3][j]   = runCode(() -> new CircleSort().sort(array));
                    case 4 -> ar2r[4][j]   = runCode(() -> new CocktailShakerSort().sort(array));
                    case 5 -> ar2r[5][j]   = runCode(() -> new CombSort().sort(array));
                    case 6 -> ar2r[6][j]   = runCode(() -> new CountingSort().sort(array));
                    case 7 -> ar2r[7][j]   = runCode(() -> new CycleSort().sort(array));
                    case 8 -> ar2r[8][j]   = runCode(() -> new DualPivotQuickSort().sort(array));
                    case 9 -> ar2r[9][j]   = runCode(() -> new DutchNationalFlagSort().sort(array));
                    case 10 -> ar2r[10][j] = runCode(() -> new GnomeSort().sort(array));
                    case 11 -> ar2r[11][j] = runCode(() -> new HashMapSort().sort(array));
                    case 12 -> ar2r[12][j] = runCode(() -> new HeapSort().sort(array));
                    case 13 -> ar2r[13][j] = runCode(() -> new InsertionSort().sort(array));
                    case 14 -> ar2r[14][j] = runCode(() -> new IntrospectiveSort().sort(array));
                    case 15 -> ar2r[15][j] = runCode(() -> new LameSort().sort(array));
                    case 16 -> ar2r[16][j] = runCode(() -> new MergeSort().sort(array));
                    case 17 -> ar2r[17][j] = runCode(() -> new PancakeSort().sort(array));
                    case 18 -> ar2r[18][j] = runCode(() -> new QuickSort().sort(array));
                    case 19 -> ar2r[19][j] = runCode(() -> new SelectionSort().sort(array));
                    case 20 -> ar2r[20][j] = runCode(() -> new ShellSort().sort(array));
                    case 21 -> ar2r[21][j] = runCode(() -> new SimpleSort().sort(array));
                    case 22 -> ar2r[22][j] = runCode(() -> new SwapSort().sort(array));
                    case 23 -> ar2r[23][j] = runCode(() -> new TimSort().sort(array));
                    case 24 -> ar2r[24][j] = runCode(() -> new TreeSort().sort(array));
                    case 25 -> ar2r[25][j] = runCode(() -> new WiggleSort().sort(array));
                }
            }
        }
        for (int i = 0; i < average.length; i++) {
            long sum = 0;
            for (int j = 0; j < iterations; j++) {
                sum += ar2r[i][j];
            }
            average[i] = sum / iterations;
        }
        printResults(average);
    }

    private static void printResults(long[] arr) {
        SortTimeTester timeTester = new SortTimeTester();
        for (int i = 0; i < sortNames.length; i++) {
            timeTester.addTime(new SortTimes(0, 0, arr[i], sortNames[i]));
        }

        ArrayList<SortTimes> timesList = timeTester.getTimes();
        Collections.sort(timesList);
        timeTester.setTimes(timesList);
        System.out.print(timeTester);
    }
}