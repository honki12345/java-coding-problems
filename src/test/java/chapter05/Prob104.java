package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Prob104 {
    @Test
    void test() {
        int[] integers = {2, 3, 4, 1};
        int maxInt = Arrays.stream(integers).max().getAsInt();

        Melon[] melons = {
                new Melon("Crenshaw", 2000),
                new Melon("Gac", 1200),
                new Melon("Bitter", 2200)};

        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
    }

    public static int max(int[] arr) {
        int max = arr[0];

        for (int element : arr) {
//            if (element > max) max = element;
            max = Math.max(max, element);
        }

        return max;
    }

    public static <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];

        for (T element : arr) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }

    public static <T> T max(T[] arr, Comparator<? super T> comparator) {
        T max = arr[0];

        for (T element : arr) {
            if (comparator.compare(element, max) > 0) {
                max = element;
            }
        }

        return max;
    }

    @Test
    void test2() {
        int[] integers = {2, 3, 4, 1};
        double asDouble = Arrays.stream(integers).average().orElseThrow();

    }

    public static double average(int[] arr) {
        return sum(arr) / arr.length;
    }

    public static double sum(int[] arr) {
        double sum = 0;

        for (int element : arr) {
            sum += element;
        }

        return sum;
    }
}
