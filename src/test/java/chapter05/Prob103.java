package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prob103 {
    @Test
    void test() {
        String[] arr = {"One", "Two", "Three", "Four", "Five"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> stream1 = Arrays.stream(arr, 0, 2);
        String[] array = stream.toArray(String[]::new);

        int[] integers = {2, 3, 4, 1};
        IntStream intStream = Arrays.stream(integers);
        IntStream intStream1 = IntStream.range(0, integers.length);
        IntStream intStream2 = IntStream.rangeClosed(0, integers.length);
        int[] array1 = intStream.toArray();
    }
}
