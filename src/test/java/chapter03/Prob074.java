package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Prob074 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        LocalDate startLocalDate = LocalDate.of(1977, 11, 2);
        LocalDate endLocalDate = LocalDate.now();

        long years = ChronoUnit.YEARS.between(startLocalDate, endLocalDate);
        System.out.println("years = " + years);

        Period periodBetween = Period.between(startLocalDate, endLocalDate);
        System.out.println("periodBetween.getYears() = " + periodBetween.getYears());
    }
}
