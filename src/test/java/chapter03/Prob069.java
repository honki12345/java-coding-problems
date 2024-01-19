package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Prob069 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        long unixTimestamp = 1573768800;
        Date date = new Date(unixTimestamp * 1000L);
        Date date2 = new Date(TimeUnit.MILLISECONDS.convert(unixTimestamp, TimeUnit.SECONDS));
        System.out.println("date = " + date);
        System.out.println("date2 = " + date2);

        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        System.out.println("instant = " + instant);

        Date date3 = Date.from(instant);
        System.out.println("date3 = " + date3);

        LocalDateTime utc = LocalDateTime
                .ofInstant(instant, ZoneId.of("UTC"));
        System.out.println("utc = " + utc);
        LocalDateTime utc2 = LocalDateTime
                .ofInstant(instant, ZoneId.of("Asia/Tokyo"));
        System.out.println("utc2 = " + utc2);
        LocalDateTime date4 = LocalDateTime
                .ofInstant(instant, ZoneId.of("Australia/Perth"));
        System.out.println("date4 = " + date4);
        ZonedDateTime date5 = ZonedDateTime
                .ofInstant(instant, ZoneId.of("Europe/Bucharest"));
        System.out.println("date5 = " + date5);
    }
}
