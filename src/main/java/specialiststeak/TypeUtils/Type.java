package specialiststeak.TypeUtils;

public enum Type {
    BYTE,
    SHORT,
    LONG,
    BOOLEAN,
    INT,
    FLOAT,
    DOUBLE,
    CHAR,
    STRING,
    OBJECT,
    BYTE_ARRAY,
    SHORT_ARRAY,
    LONG_ARRAY,
    BOOLEAN_ARRAY,
    INT_ARRAY,
    FLOAT_ARRAY,
    DOUBLE_ARRAY,
    CHAR_ARRAY,
    STRING_ARRAY,
    OBJECT_ARRAY;

    /**
     * Returns the approximate storage size of the type
     *
     * @return approximate storage size of the type:
     * <p>
     * -1 if the type is a String or Object
     * <p>
     * -2 if the type is an array of primitives
     * <p>
     * -3 if the type is an array of Strings or Objects
     * </p>
     */
    public int getApproximateStorageSize() {
        return switch (this) {
            case BYTE, BOOLEAN -> 1;
            case SHORT, CHAR -> 2;
            case INT, FLOAT -> 4;
            case LONG, DOUBLE -> 8;
            case STRING, OBJECT -> -1;
            case INT_ARRAY, FLOAT_ARRAY, SHORT_ARRAY, CHAR_ARRAY, LONG_ARRAY, DOUBLE_ARRAY, BYTE_ARRAY, BOOLEAN_ARRAY ->
                    -2;
            case STRING_ARRAY, OBJECT_ARRAY -> -3;
        };
    }

    /**
     * @return type of the variable as a String
     */
    public String toString() {
        return switch (this) {
            case BYTE -> "byte";
            case SHORT -> "short";
            case LONG -> "long";
            case BOOLEAN -> "boolean";
            case INT -> "int";
            case FLOAT -> "float";
            case DOUBLE -> "double";
            case CHAR -> "char";
            case STRING -> "String";
            case OBJECT -> "Object";
            case BYTE_ARRAY -> "byte[]";
            case SHORT_ARRAY -> "short[]";
            case LONG_ARRAY -> "long[]";
            case BOOLEAN_ARRAY -> "boolean[]";
            case INT_ARRAY -> "int[]";
            case FLOAT_ARRAY -> "float[]";
            case DOUBLE_ARRAY -> "double[]";
            case CHAR_ARRAY -> "char[]";
            case STRING_ARRAY -> "String[]";
            case OBJECT_ARRAY -> "Object[]";
        };
    }
}