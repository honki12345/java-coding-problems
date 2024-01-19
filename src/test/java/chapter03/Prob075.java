package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;

public class Prob075 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        LocalDate localDate = LocalDate.of(2019, 2, 28);
        LocalDateTime ldDayStart = localDate.atStartOfDay();
        System.out.println("ldDayStart = " + ldDayStart);

        LocalDateTime ldDayStart2 = LocalDateTime.of(localDate, LocalTime.MIN);
        System.out.println("ldDayStart2 = " + ldDayStart2);

        LocalDateTime ldDayEnd = localDate.atTime(LocalTime.MAX);
        System.out.println("ldDayEnd = " + ldDayEnd);

        LocalDateTime ldDayEnd2 = LocalTime.MAX.atDate(localDate);
        System.out.println("ldDayEnd2 = " + ldDayEnd2);
    }

    @DisplayName("")
    @Test
    void test2() {
        // Given // When // Then
        LocalDate localDate = LocalDate.of(2019, 2, 28);

        ZonedDateTime ldDayStartZone = localDate.atStartOfDay(ZoneId.of("Australia/Perth"));
        System.out.println("ldDayStartZone = " + ldDayStartZone);

//        ZonedDateTime ldDayStartZone2 = LocalDateTime.of(localDate, LocalDateTime.MIN).atZone(ZoneId.of("Australia/Perth"));

        ZonedDateTime ldDayEndZone = localDate.atTime(LocalTime.MAX).atZone(ZoneId.of("Australia/Perth"));
        ZonedDateTime ldDayEndZone2 = LocalTime.MAX.atDate(localDate)
                .atZone(ZoneId.of("Australia/Perth"));

        LocalDateTime localDateTime = LocalDateTime.of(2019, 2, 28, 18, 0, 0);

        LocalDateTime ldtDayStart = localDateTime
                .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay());

        LocalDateTime ldtDayStart2 = localDateTime.with(ChronoField.HOUR_OF_DAY, 0);

        LocalDateTime ldtDayEnd = localDateTime
                .with(ChronoField.NANO_OF_DAY, LocalTime.MAX.toNanoOfDay());

        localDateTime.with(
                ChronoField.NANO_OF_DAY, 86399999999999L
        );

        ZonedDateTime ldtDayStartZone = localDateTime
                .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay())
                .atZone(ZoneId.of("Australia/Perth"));

        ZonedDateTime ldtDayEndZone = localDateTime
                .with(ChronoField.NANO_OF_DAY, LocalTime.MAX.toNanoOfDay())
                .atZone(ZoneId.of("Australia/Perth"));
    }

    @DisplayName("")
    @Test
    void test3() {
        // Given // When // Then
        ZonedDateTime zdt = ZonedDateTime.now(ZoneOffset.UTC);

        ZonedDateTime dayStartZdt = zdt.toLocalDate().atStartOfDay(zdt.getZone());
        ZonedDateTime dayEndZdt = zdt.toLocalDate().atTime(LocalTime.MAX).atZone(zdt.getZone());
    }
}
