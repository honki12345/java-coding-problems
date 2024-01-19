package chapter04;

import chapter03.ChessClock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class Prob092 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
    }

    public Report checkPlayer() {
        var player = new Player();
        var timestamp = new Date();
        var report = fetchReport(player, timestamp);

        return report;
    }

    public Report fetchReport(Player player, Date timestamp) {
        return new Report();
    }
}
