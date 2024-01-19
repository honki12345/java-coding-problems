package chapter05;

import java.util.Arrays;

public final class ImmutableArray<T> {
    private final T[] array;

    private ImmutableArray(T[] arr) {
        array = Arrays.copyOf(arr, arr.length);
    }

    public static <T> ImmutableArray<T> from(T[] a) {
        return new ImmutableArray<>(a);
    }

    public T get(int index) {
        return array[index];
    }
}
