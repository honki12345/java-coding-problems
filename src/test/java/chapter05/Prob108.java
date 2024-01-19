package chapter05;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Prob108 {
    @Test
    void test() {

    }

    public static int[] add(int[] arr, int item) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = item;
        return newArr;
    }

    public static int[] remove(int[] arr) {
        return Arrays.copyOf(arr, arr.length - 1);
    }

    public static int[] resize(int[] arr, int length) {
        return Arrays.copyOf(arr, arr.length + length);
    }

    public static <T> T[] copyOf(T[] original, int newLength) {
        T[] copy = (original.getClass() == Object[].class) ?
                (T[]) new Object[newLength] :
                (T[]) Array.newInstance(original.getClass().getComponentType(), newLength);
        return copy;
    }
}
