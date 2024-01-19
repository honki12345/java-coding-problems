package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;

public class Prob071 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        ZoneOffset zoneOffsetUTC = ZoneOffset.UTC;

        ZoneId defaultZoneId = ZoneOffset.systemDefault();
        System.out.println("defaultZoneId = " + defaultZoneId);

        LocalDateTime ldt = LocalDateTime.of(2019, 6, 15, 0, 0);
        ZoneId zoneId = ZoneId.of("Europe/Bucharest");

        ZoneOffset zoneOffset = zoneId.getRules().getOffset(ldt);
        System.out.println("zoneId = " + zoneId);
        System.out.println("zoneOffset = " + zoneOffset);

        ZoneOffset zoneOffsetFromString = ZoneOffset.of("+02:00");
        System.out.println("zoneOffsetFromString = " + zoneOffsetFromString);

        OffsetTime offsetTime = OffsetTime.now(zoneOffsetFromString);
        System.out.println("OffsetTime.now() = " + OffsetTime.now());
        System.out.println("offsetTime = " + offsetTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffsetFromString);
        System.out.println("offsetDateTime = " + offsetDateTime);

        ZoneOffset zoneOffsetFromHoursMinutes = ZoneOffset.ofHoursMinutes(8, 30);
        ZoneOffset zoneOffsetFromOdt = offsetDateTime.getOffset();
        System.out.println("zoneOffsetFromOdt = " + zoneOffsetFromOdt);

        ZoneOffset zoneOffset1 = OffsetDateTime.now().getOffset();
        System.out.println("zoneOffset1 = " + zoneOffset1);
    }
}
