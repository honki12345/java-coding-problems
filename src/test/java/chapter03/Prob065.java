package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Prob065 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldtAfterAddingMinutes = ldt.plusMinutes(10);
        LocalDateTime ldtAfterSubtractingMinutes = ldt.minusMinutes(10);

        Instant timestamp = Instant.now();
        Instant timestampAfterAddingHours = timestamp.plus(5, ChronoUnit.HOURS);
        Instant timestampAfterSubtractingHours = timestamp.minus(5, ChronoUnit.HOURS);
    }

    @DisplayName("")
    @Test
    void test2() {
        // Given // When // Then
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
/*
        for (String zoneId : zoneIds) {
            System.out.println("zoneId = " + zoneId);
        }
*/
        ZoneId zoneId = ZoneId.of("America/Marigot");

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        ZonedDateTime zdt = now.atZone(ZoneId.of("America/Marigot"));
        System.out.println("zdt = " + zdt);

        String id = zdt.getOffset().getId();
        System.out.println("id = " + id);
        String utcOffset = zdt.getOffset().getId().replace("Z", "+00:00");
        System.out.println("utcOffset = " + utcOffset);
    }

    public static List<String> fetchTimeZones(OffsetType type) {
        List<String> timezones = new ArrayList<>();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        LocalDateTime now = LocalDateTime.now();

        zoneIds.forEach((zoneId) -> {
            timezones.add("(" + type + now.atZone(ZoneId.of(zoneId))
                    .getOffset().getId().replace("Z", "+00:00") + ")" + zoneId);
        });

        return timezones;
    }

    @DisplayName("")
    @Test
    void test3() {
        // Given // When // Then
        List<String> timezones = fetchTimeZones(OffsetType.GMT);
        timezones.forEach(System.out::println);
    }
}

enum OffsetType {
        GMT, UTC
}
