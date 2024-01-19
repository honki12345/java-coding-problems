package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Prob105 {
    @Test
    void test() {
        int[] integers = {-1, 2, 3, 1, 4, 5, 3, 2, 22};

        int[] reversed = IntStream.rangeClosed(1, integers.length)
                .map(i -> integers[integers.length - i]).toArray();

        Melon[] melons = {
                new Melon("Crenshaw", 1000),
                new Melon("Gac", 2200),
                new Melon("Bitter", 3200)};

        Arrays.sort(melons, Comparator.reverseOrder());
        System.out.println("Arrays.toString(melons) = " + Arrays.toString(melons));
/*
        Collections.reverse(Arrays.asList(melons));
        Melon[] reversed2 = IntStream.rangeClosed(1, melons.length)
                .mapToObj(i -> melons[melons.length - i])
                .toArray(Melon[]::new);
*/
    }

    public static void reverse(int[] arr) {
        for (int leftHead = 0, rightHead = arr.length - 1;
             leftHead < rightHead; leftHead++, rightHead--) {
            int element = arr[leftHead];
            arr[leftHead] = arr[rightHead];
            arr[rightHead] = element;
        }
    }

    public static <T> void reverse(T[] arr) {
        for (int leftHead = 0, rightHead = arr.length - 1;
             leftHead < rightHead; leftHead++, rightHead--) {
            T element = arr[leftHead];
            arr[leftHead] = arr[rightHead];
            arr[rightHead] = element;
        }
    }
}
