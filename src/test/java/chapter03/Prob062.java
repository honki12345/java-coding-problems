package chapter03;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob062 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        /*Instant 클래스는 기계시간의 타임스탬프를 생성할 때 아주 유용하다*/
        Instant timestamp = Instant.now();
        System.out.println("timestamp = " + timestamp);
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        Clock clock = Clock.systemUTC();

        Instant timestampFromString = Instant.parse("2019-02-24T14:31:33.197021300Z");

        Instant tenMinutesEarlier = Instant.now().plus(2, ChronoUnit.HOURS);

        Instant timestamp1 = Instant.now();
        Instant timestamp2 = timestamp1.plusSeconds(10);

        boolean isAfter = timestamp1.isAfter(timestamp2);
        System.out.println("isAfter = " + isAfter);
        boolean isBefore = timestamp1.isBefore(timestamp2);
        long difference = timestamp1.until(timestamp2, ChronoUnit.SECONDS);
        System.out.println("difference = " + difference);
    }

    @DisplayName("")
    @Test
    void test2() {
        // given // when // then
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        Instant instantLDT = LocalDateTime.now().toInstant(ZoneOffset.UTC);

        ZonedDateTime zdt = Instant.now().atZone(ZoneId.of("Europe/Paris"));
        Instant instantZDT = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris")).toInstant();

        OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.of("+02:00"));
        Instant instantODT = LocalDateTime.now().atOffset(ZoneOffset.of("+02:00")).toInstant();
    }

}
