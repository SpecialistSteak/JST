package specialiststeak.Algorithms;

import java.util.Random;

public class Shuffle {

    /**
     * Shuffles an array of objects using the Fisher-Yates algorithm.
     *
     * @param array The array to shuffle
     * @param <T>   The type of the array
     */
    public static <T> void shuffle(T[] array) {
        int n = array.length;
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomValue = i + random.nextInt(n - i);
            T randomElement = array[randomValue];
            array[randomValue] = array[i];
            array[i] = randomElement;
        }
    }
}
