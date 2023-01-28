package specialiststeak.Population;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import static specialiststeak.Population.Convert.toIntArray;
import static specialiststeak.Population.Types.getValue;

public class PopulateArray {
    /**
     * Populates an array with random values of the given type
     *
     * @param type The type of the array
     * @param size The size of the array
     * @return The populated array
     */
    public static Object[] populate(Types type, int size) {
        Integer[] IntegerArray;
        Long[] LongArray;
        Double[] DoubleArray;
        Float[] FloatArray;
        Short[] ShortArray;
        Byte[] ByteArray;
        Character[] CharacterArray;
        Boolean[] BooleanArray;
        String[] StringArray;
        switch (type) {
            case INT -> {
                IntegerArray = new Integer[size];
                for (int i = 0; i < size; i++) {
                    IntegerArray[i] = (Integer) getValue(type);
                }
                return IntegerArray;
            }
            case LONG -> {
                LongArray = new Long[size];
                for (int i = 0; i < size; i++) {
                    LongArray[i] = (Long) getValue(type);
                }
                return LongArray;
            }
            case DOUBLE -> {
                DoubleArray = new Double[size];
                for (int i = 0; i < size; i++) {
                    DoubleArray[i] = (Double) getValue(type);
                }
                return DoubleArray;
            }
            case FLOAT -> {
                FloatArray = new Float[size];
                for (int i = 0; i < size; i++) {
                    FloatArray[i] = (Float) getValue(type);
                }
                return FloatArray;
            }
            case SHORT -> {
                ShortArray = new Short[size];
                for (int i = 0; i < size; i++) {
                    ShortArray[i] = (Short) getValue(type);
                }
                return ShortArray;
            }
            case BYTE -> {
                ByteArray = new Byte[size];
                for (int i = 0; i < size; i++) {
                    ByteArray[i] = (Byte) getValue(type);
                }
                return ByteArray;
            }
            case CHAR -> {
                CharacterArray = new Character[size];
                for (int i = 0; i < size; i++) {
                    CharacterArray[i] = (Character) getValue(type);
                }
                return CharacterArray;
            }
            case BOOLEAN -> {
                BooleanArray = new Boolean[size];
                for (int i = 0; i < size; i++) {
                    BooleanArray[i] = (Boolean) getValue(type);
                }
                return BooleanArray;
            }
            case STRING -> {
                StringArray = new String[size];
                for (int i = 0; i < size; i++) {
                    StringArray[i] = (String) getValue(type);
                }
                return StringArray;
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    /**
     * Clones an object and modifies its fields to random values.
     * This method is not guaranteed to work with all objects, but it should work with most.
     * It will not work on objects with final fields, or fields that are not primitives,
     * Strings, or Serializable objects.
     *
     * @param obj The object to clone
     * @return The cloned object
     * @author specialiststeak
     * @see Field
     */
    public static Object cloneAndModify(Object obj) {
        try {
            Object clone = obj.getClass().getDeclaredConstructor().newInstance();
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getType().isPrimitive()) {
                    Random random = new Random();
                    if (field.getType().equals(int.class)) {
                        field.set(clone, random.nextInt());
                    } else if (field.getType().equals(long.class)) {
                        field.set(clone, random.nextLong());
                    } else if (field.getType().equals(double.class)) {
                        field.set(clone, random.nextDouble());
                    } else if (field.getType().equals(float.class)) {
                        field.set(clone, random.nextFloat());
                    } else if (field.getType().equals(short.class)) {
                        field.set(clone, (short) random.nextInt(-32_768, 32_767));
                    } else if (field.getType().equals(byte.class)) {
                        field.set(clone, (byte) random.nextInt(-128, 127));
                    } else if (field.getType().equals(char.class)) {
                        field.set(clone, (char) getValue(Types.CHAR));
                    } else if (field.getType().equals(boolean.class)) {
                        field.set(clone, Math.random() > 0.5);
                    }
                } else if (field.getType().equals(String.class)) {
                    field.set(clone, getValue(Types.STRING));
                } else if (field.getType().equals(int[].class)) {
                    field.set(clone, toIntArray(populate(Types.INT, 10)));
                } else if (field.getType().equals(double[].class)) {
                    field.set(clone, toIntArray(populate(Types.DOUBLE, 10)));
                } else if (field.getType().equals(char[].class)) {
                    field.set(clone, toIntArray(populate(Types.CHAR, 10)));
                } else if (field.getType().equals(String[].class)) {
                    field.set(clone, toIntArray(populate(Types.STRING, 10)));
                } else if (Serializable.class.isAssignableFrom(field.getType())) {
                    field.set(clone, cloneAndModify(field.get(obj)));
                }
            }
            return clone;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
