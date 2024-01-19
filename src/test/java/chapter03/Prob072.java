package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Date;

public class Prob072 {
    public static final ZoneId DEFAULT_TIME_ZONE = ZoneId.systemDefault();

    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        Date date = new Date();
        Instant instantFromDate = date.toInstant();
        System.out.println("date = " + date);
        System.out.println("instantFromDate = " + instantFromDate);
    }

    public static Instant dateToInstant(Date date) {
        return date.toInstant();
    }

    public static Date instantToDate(Instant instant) {
        return Date.from(instant);
    }

    public static LocalDate dateToLocalDate(Date date) {
        return dateToInstant(date).atZone(DEFAULT_TIME_ZONE).toLocalDate();
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(DEFAULT_TIME_ZONE).toInstant());
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return dateToInstant(date).atZone(DEFAULT_TIME_ZONE).toLocalDateTime();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(DEFAULT_TIME_ZONE).toInstant());
    }

    public static ZonedDateTime dateToZonedDateTime(Date date) {
        return dateToInstant(date).atZone(DEFAULT_TIME_ZONE);
    }

    public static Date zonedDateTimeToDate(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    public static OffsetDateTime dateToOffsetDateTime(Date date) {
        return dateToInstant(date).atZone(DEFAULT_TIME_ZONE).toOffsetDateTime();
    }

    public static Date offsetDateTimeToDate(OffsetDateTime offsetDateTime) {
        return Date.from(offsetDateTime.toLocalDateTime().toInstant(ZoneOffset.of(offsetDateTime.getOffset().getId())));
    }

    public static LocalTime dateToLocalTime(Date date) {
        return LocalTime.ofInstant(dateToInstant(date), DEFAULT_TIME_ZONE);
    }

/*
    public static Date localTimeToDate(LocalTime localTime) {
        return Date.from(localTime.atDate(LocalDate.EPOCH).toInstant(DEFAULT_TIME_ZONE.getRules().getOffset(Instant.now()));
    }
*/
}
