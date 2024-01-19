package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Prob073 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        LocalDate startLocalDate = LocalDate.of(2019, 2, 1);
        LocalDate endLocalDate = LocalDate.of(2019, 2, 21);

        for (LocalDate date = startLocalDate; date.isBefore(endLocalDate); date = date.plusDays(1)) {
            System.out.println(date);
        }
    }

    @DisplayName("")
    @Test
    void test2() {
        // Given // When // Then
        LocalDate startLocalDate = LocalDate.of(2019, 2, 1);
        LocalDate endLocalDate = LocalDate.of(2019, 2, 21);

        startLocalDate.datesUntil(endLocalDate).forEach(System.out::println);
    }
}
