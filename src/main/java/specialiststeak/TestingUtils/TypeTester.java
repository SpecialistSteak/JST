package specialiststeak.TestingUtils;

import specialiststeak.TypeUtils.Type;

public class TypeTester {

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(byte x) {
        return Type.BYTE;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(short x) {
        return Type.SHORT;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(long x) {
        return Type.LONG;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(boolean x) {
        return Type.BOOLEAN;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(int x) {
        return Type.INT;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(float x) {
        return Type.FLOAT;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(double x) {
        return Type.DOUBLE;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(char x) {
        return Type.CHAR;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(String x) {
        return Type.STRING;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(Object x) {
        return Type.OBJECT;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(byte[] x) {
        return Type.BYTE_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(short[] x) {
        return Type.SHORT_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(long[] x) {
        return Type.LONG_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(boolean[] x) {
        return Type.BOOLEAN_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(int[] x) {
        return Type.INT_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(float[] x) {
        return Type.FLOAT_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(double[] x) {
        return Type.DOUBLE_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(char[] x) {
        return Type.CHAR_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(String[] x) {
        return Type.STRING_ARRAY;
    }

    /**
     * Returns the Type of the variable
     *
     * @param x variable to get the type of
     * @return Type of the variable
     */
    public static Type getVarType(Object[] x) {
        return Type.OBJECT_ARRAY;
    }

    /**
     * Returns the type of the variable as a String
     *
     * @param x variable to get the type of
     * @return Type of the variable as a String
     */
    public static String getVarTypeName(Object x) {
        return x.getClass().getSimpleName();
    }

    /**
     * Prints the type of the variable. Note that if a primitive type is passed, it will be returned as the wrapper class
     *
     * @param o variable to get the type of
     */
    public static void printVarTypeName(Object o) {
        System.out.println(o.toString() + ": " + o.getClass().getSimpleName());
    }
}