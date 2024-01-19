package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Prob091 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        List<Integer> ints = List.of(1, 2, 3, 4, 4, 6, 2, 1, 5, 4, 5);

        int result = ints.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0))
                .values()
                .stream()
                .max(Comparator.comparing(List::size))
                .orElse(Collections.emptyList())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    @DisplayName("")
    @Test
    void test2() {
        // Given // When // Then
        List<Integer> ints = List.of(1, 2, 3, 4, 4, 6, 2, 1, 5, 4, 5);

        Collection<List<Integer>> evenAndOdd = ints.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0))
                .values();

        List<Integer> evenOrOdd = evenAndOdd.stream()
                .max(Comparator.comparing(List::size))
                .orElse(Collections.emptyList());

        int sumEvenOrOdd = evenOrOdd.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    @DisplayName("")
    @Test
    void test3() {
        // Given // When // Then
        List<Integer> intList = List.of(1, 2, 3, 4, 4, 6, 2, 1, 5, 4, 5);

        var evenAndOdd = intList.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0))
                .values();
        var evenOrOdd = evenAndOdd.stream()
                .max(Comparator.comparing(List::size))
                .orElse(Collections.emptyList());
        var sumEvenOrOdd = evenOrOdd.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
