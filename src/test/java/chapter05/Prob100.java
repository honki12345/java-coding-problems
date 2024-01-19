package chapter05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Prob100 {
    @Test
    void test() {
        int[] numbers = {4, 5, 1, 3, 7, 4, 1};
    }

    public static boolean containsElement(int[] arr, int toContain) {
        for (int element : arr) {
            if (element == toContain) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsElement2(int[] arr, int toContain) {
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, toContain);

        return (index >= 0);
    }

    public static boolean containsElement3(int[] arr, int toContain) {
        return Arrays.stream(arr)
                .anyMatch(e -> e == toContain);
    }

    @Test
    void test2() {
        Melon[] melons = {new Melon("Crenshaw", 2000), new Melon("Gac", 1200), new Melon("Bitter", 2200)};
    }

    public static <T> boolean containsElementObject(T[] arr, T toContain) {
        for (T element : arr) {
            if (element.equals(toContain)) {
                return true;
            }
        }

        return false;
    }

    public static <T> boolean containsElementObject(T[] arr, T toContain, Comparator<? super T> comparator) {
        for (T element : arr) {
            if (comparator.compare(element, toContain) == 0) {
                return true;
            }
        }

        return false;
    }

    @Test
    void test3() {
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
        Melon[] melons = {new Melon("Crenshaw", 2000), new Melon("Gac", 1200), new Melon("Bitter", 2200)};

        boolean found = containsElementObject(melons, new Melon("Gac", 1200), byType);
        System.out.println("found = " + found);
    }

    public static int findIndexOfElement(int[] arr, int toFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                return i;
            }
        }

        return -1;
    }

    public static int findIndexOfElement2(int[] arr, int toFind) {
        return IntStream.range(0, arr.length)
                .filter(i -> toFind == arr[i])
                .findFirst()
                .orElse(-1);
    }

    public static <T> int findIndexOfElementObject(T[] arr, T toFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(toFind)) {
                return i;
            }
        }

        return -1;
    }

    public static <T> int findIndexOfElementObject(T[] arr, T toFind, Comparator<? super T> c) {
        for (int i = 0; i < arr.length; i++) {
            if (c.compare(arr[i], toFind) == 0) {
                return i;
            }
        }

        return -1;
    }

    public static <T> int findIndexOfElementObject2(T[] arr, T toFind, Comparator<? super T> c) {
        return IntStream.range(0, arr.length)
                .filter(i -> c.compare(toFind, arr[i]) == 0)
                .findFirst()
                .orElse(-1);
    }
}
