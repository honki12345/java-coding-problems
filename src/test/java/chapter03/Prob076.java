package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Prob076 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        LocalDate ld1 = LocalDate.of(2018, 1, 1);
        LocalDate ld2 = LocalDate.of(2019, 3, 1);

        long betweenInDays = Math.abs(ChronoUnit.DAYS.between(ld1, ld2));
        long betweenInMonths = Math.abs(ChronoUnit.MONTHS.between(ld1, ld2));
        long betweenInYears = Math.abs(ChronoUnit.YEARS.between(ld1, ld2));

        Period period = ld1.until(ld2);
        System.out.printf("Difference as Period: %dy%dm%dd", period.getYears(), period.getMonths(), period.getDays());

        long untilInDays = Math.abs(ld1.until(ld2, ChronoUnit.DAYS));
        long untilInMonths = Math.abs(ld1.until(ld2, ChronoUnit.MONTHS));
        long untilInYears = Math.abs(ld1.until(ld2, ChronoUnit.YEARS));
    }

    @DisplayName("")
    @Test
    void test2() {
        // Given // When // Then
        LocalDateTime ldt1 = LocalDateTime.of(2018, 1, 1, 22, 15, 15);
        LocalDateTime ldt2 = LocalDateTime.of(2018, 1, 1, 23, 15, 15);
        long betweenInMinutesWithoutZone = Math.abs(ChronoUnit.MINUTES.between(ldt1, ldt2));

        long untilInMinutesWithoutZone = Math.abs(ldt1.until(ldt2, ChronoUnit.HOURS));

        ZonedDateTime zdt1 = ldt1.atZone(ZoneId.of("Europe/Bucharest"));
        ZonedDateTime zdt2 = zdt1.withZoneSameInstant(ZoneId.of("Australia/Perth")).plusHours(1);
        System.out.println("zdt1 = " + zdt1);
        System.out.println("zdt2 = " + zdt2);

        long betweenInMinutesWithZone = Math.abs(ChronoUnit.MINUTES.between(zdt1, zdt2));
        System.out.println("betweenInMinutesWithZone = " + betweenInMinutesWithZone);

        long untilInHoursWithZone = Math.abs(zdt1.until(zdt2, ChronoUnit.HOURS));
    }
}
