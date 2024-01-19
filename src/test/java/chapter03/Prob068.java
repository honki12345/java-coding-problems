package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;

public class Prob068 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        LocalDateTime ldt = LocalDateTime.of(2019, Month.FEBRUARY, 26, 16, 00);

//        호주/퍼스의 시간대(+08:00)와 합친다
        ZonedDateTime auPerthDepart = ldt.atZone(ZoneId.of("Australia/Perth"));

        ZonedDateTime auPerthArrive = auPerthDepart.plusHours(15).plusMinutes(30);

        ZonedDateTime euBucharestDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        ZonedDateTime euBucharestArrive = auPerthArrive.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));

        System.out.println("auPerthDepart = " + auPerthDepart);
        System.out.println("euBucharestDepart = " + euBucharestDepart);

        System.out.println("auPerthArrive = " + auPerthArrive);
        System.out.println("euBucharestArrive = " + euBucharestArrive);

        OffsetDateTime utcAtDepart = auPerthDepart.withZoneSameInstant(
                ZoneId.of("UTC")).toOffsetDateTime();
        System.out.println("utcAtDepart = " + utcAtDepart);
        OffsetDateTime utcAtDepart2 = euBucharestDepart.withZoneSameInstant(
                ZoneId.of("UTC")).toOffsetDateTime();
        System.out.println("utcAtDepart2 = " + utcAtDepart2);
        OffsetDateTime utcAtArrive = auPerthArrive.withZoneSameInstant(
                ZoneId.of("UTC")).toOffsetDateTime();
        System.out.println("utcAtArrive = " + utcAtArrive);
    }
}
