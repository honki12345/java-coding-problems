package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Prob077 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        Clock fixedClock = Clock.fixed(Instant.now(), ZoneOffset.UTC);
        Clock tickClock = Clock.tickSeconds(ZoneId.of("Europe/Bucharest"));
        System.out.println(tickClock.instant());
    }
}
