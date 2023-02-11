package specialiststeak.Algorithms.Sorts;

import java.util.Arrays;

import static specialiststeak.Algorithms.Sorts.SortUtils.less;

public class SwapSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int LENGTH = array.length;
        int index = 0;

        while (index < LENGTH - 1) {
            int amountSmallerElements = this.getSmallerElementCount(array, index);

            if (amountSmallerElements > 0 && index != amountSmallerElements) {
                T element = array[index];
                array[index] = array[amountSmallerElements];
                array[amountSmallerElements] = element;

                if (array[index].equals(element)) {
                    index++;
                }
            } else {
                index++;
            }
        }

        return array;
    }

    private <T extends Comparable<T>> int getSmallerElementCount(T[] array, int index) {
        return (int) Arrays.stream(array).filter(t -> less(t, array[index])).count();
    }
}
