package chapter03;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob063 {

    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        Period fromDays = Period.ofDays(120);
        Period periodFromUnits = Period.of(2000, 11, 24);

        LocalDate localDate = LocalDate.now();
        Period periodFromLocalDate = Period.of(localDate.getYear(), localDate.getMonthValue(),
            localDate.getDayOfMonth());

        Period periodFromString = Period.parse("P2019Y2M25D");

        LocalDate startLocalDate = LocalDate.of(2018, 3, 12);
        LocalDate endLocalDate = LocalDate.of(2019, 7, 20);
        Period periodBetween = Period.between(startLocalDate, endLocalDate);

        System.out.println("periodToYMD(periodBetween) = " + periodToYMD(periodBetween));

        periodBetween.isNegative();
        Period periodBetweenPlus1Year = periodBetween.plusYears(1L);
        Period p1 = Period.ofDays(5);
        Period p2 = Period.ofDays(20);
        Period p1p2 = p1.plus(p2);
    }

    public static String periodToYMD(Period period) {
        StringBuilder sb = new StringBuilder();
        sb.append(period.getYears())
            .append("y:")
            .append(period.getMonths())
            .append("m:")
            .append(period.getDays())
            .append("d");
        return sb.toString();
    }

    @DisplayName("")
    @Test
    void test2() {
        // given // when // then
        Duration fromHours = Duration.ofHours(10);
        Duration fromMinutes = Duration.of(3, ChronoUnit.MINUTES);
        LocalDateTime localDateTime =
            LocalDateTime.of(2018, 3, 12, 4, 14, 20, 670);
        Duration fromLocalDateTime = Duration.ofMinutes(localDateTime.getMinute());

        LocalTime localTime = LocalTime.of(4, 14, 20, 670);
        Duration fromLocalTime = Duration.ofNanos(localTime.getNano());

        Duration durationFromString = Duration.parse("P2DT3H4M");

        Instant startInstant = Instant.parse("2015-11-03T12:11:30.00Z");
        Instant endInstant = Instant.parse("2016-12-06T15:17:10.00Z");
        Duration durationBetweenInstant = Duration.between(startInstant, endInstant);
        durationBetweenInstant.getSeconds();

        LocalDateTime startLocalDateTime =
            LocalDateTime.of(2018, 3, 12, 4, 14, 20, 670);
        LocalDateTime endLocalDateTime =
            LocalDateTime.of(2019, 7, 20, 6, 10, 10, 720);
        Duration durationBetweenLDT = Duration.between(startLocalDateTime, endLocalDateTime);

        LocalTime startLocalTime = LocalTime.of(4, 14, 20, 670);
        LocalTime endLocalTime = LocalTime.of(6, 10, 10, 720);
        Duration durationBetweenLT = Duration.between(startLocalTime, endLocalTime);

        String s = durationToDHMSN(durationBetweenLT);
        System.out.println("s = " + s);
        String s1 = durationToDHMSN(durationBetweenLDT);
        System.out.println("s1 = " + s1);

        Duration durationBetweenPlus5Hours = durationBetweenLT.plusHours(5);

        Duration d1 = Duration.ofMinutes(20);
        Duration d2 = Duration.ofHours(2);

        Duration d1d2 = d1.plus(d2);
        String s2 = durationToDHMSN(d1d2);
        System.out.println("s2 = " + s2);
    }

    public static String durationToDHMSN(Duration duration) {
        StringBuilder sb = new StringBuilder();
        sb.append(duration.toDays())
            .append("d:")
            .append(duration.toHoursPart())
            .append("h:")
            .append(duration.toMinutesPart())
            .append("m:")
            .append(duration.toSecondsPart())
            .append("s:")
            .append(duration.toNanosPart())
            .append("n");
        return sb.toString();
    }
}