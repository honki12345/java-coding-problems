package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Prob067 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        ZonedDateTime zlt = ZonedDateTime.now();

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        List<String> strings = localTimeToAllTimeZones();
        strings.forEach(System.out::println);
    }

    public static List<String> localTimeToAllTimeZones() {
        List<String> result = new ArrayList<>();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss a Z");
        ZonedDateTime zlt = ZonedDateTime.now();
        zoneIds.forEach((zoneId) -> {
            result.add(zlt.format(formatter) + " in " + zoneId + " is " +
                    zlt.withZoneSameInstant(ZoneId.of(zoneId))
                            .format(formatter));
        });

        return result;
    }
}
