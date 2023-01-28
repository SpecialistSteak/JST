package specialiststeak.Population;

import java.util.Arrays;

public class Convert {
    /**
     * Converts an Object[] to an int[]
     *
     * @param arr Object[] to convert
     * @return int[] of the Object[]
     */
    public static int[] toIntArray(Object[] arr) {
        return Arrays.stream(Arrays.copyOf(arr, arr.length, Integer[].class)).mapToInt(Integer::intValue).toArray();
    }

    /**
     * Converts an Object[] to a double[]
     *
     * @param arr Object[] to convert
     * @return double[] of the Object[]
     */
    public static double[] toDoubleArray(Object[] arr) {
        return Arrays.stream(Arrays.copyOf(arr, arr.length, Double[].class)).mapToDouble(Double::doubleValue).toArray();
    }

    /**
     * Converts an Object[] to a Character[]
     *
     * @param arr Object[] to convert
     * @return Character[] of the Object[]
     */
    public static Character[] toCharacterArray(Object[] arr) {
        return Arrays.copyOf(arr, arr.length, Character[].class);
    }

    /**
     * Converts an Object[] to a String[]
     *
     * @param arr Object[] to convert
     * @return String[] of the Object[]
     */
    public static String[] toStringArray(Object[] arr) {
        return Arrays.copyOf(arr, arr.length, String[].class);
    }
}
