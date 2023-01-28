package specialiststeak.Population;

import java.util.Random;

public enum Types {
    INT,
    DOUBLE,
    STRING,
    CHAR,
    BOOLEAN,
    LONG,
    FLOAT,
    SHORT,
    BYTE,
    OBJECT;

    /**
     * Returns the type as a string
     *
     * @param type the type to convert
     * @return the type as a string
     */
    public static String typeAsString(Types type) {
        return switch (type) {
            case INT -> "int";
            case DOUBLE -> "double";
            case STRING -> "String";
            case CHAR -> "char";
            case BOOLEAN -> "boolean";
            case LONG -> "long";
            case FLOAT -> "float";
            case SHORT -> "short";
            case BYTE -> "byte";
            case OBJECT -> "Object";
        };
    }

    /**
     * Returns a random value of the type as one of the big types (ex. int -> Integer) of it's type
     *
     * @param type the type to get a value of
     * @return a random value of the type
     */
    public static Object getValue(Types type) {
        Random random = new Random();
        return switch (type) {
            case INT -> {
                yield (Integer) random.nextInt();
            }
            case DOUBLE -> {
                yield (Double) random.nextDouble();
            }
            case LONG -> {
                yield (Long) random.nextLong();
            }
            case STRING -> {
                String possibleChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+{}|:\"<>?[];',./`~";
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < random.nextInt(1, 128); i++) {
                    sb.append(possibleChars.charAt(random.nextInt(possibleChars.length())));
                }
                yield (String) sb.toString();
            }
            case CHAR -> {
                String possibleChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+{}|:\"<>?[];',./`~";
                yield (Character) possibleChars.charAt(random.nextInt(possibleChars.length()));
            }
            case BOOLEAN -> {
                if (random.nextBoolean()) {
                    yield (Boolean) false;
                }
                yield (Boolean) false;
            }
            case FLOAT -> {
                yield (Float) random.nextFloat();
            }
            case SHORT -> {
                yield (Short) (short) random.nextInt(-32_768, 32_767);
            }
            case BYTE -> {
                yield (Byte) (byte) random.nextInt(-128, 127);
            }
            case OBJECT -> {
                yield new Object();
            }
        };
    }
}
