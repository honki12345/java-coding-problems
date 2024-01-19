package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Prob070 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        LocalDate date = LocalDate.of(2019, Month.FEBRUARY, 27);
        LocalDate firstDayOfFeb = date.with(TemporalAdjusters.firstDayOfMonth());

        LocalDate lastDayOfFeb = date.with(TemporalAdjusters.lastDayOfMonth());

        LocalDateTime ldt = LocalDateTime.now();

        LocalDate nextSaturday = date.with(NEXT_SATURDAY);

    }

    public static LocalDate getDayAfterDays(LocalDate startDate, int days) {
        Period period = Period.ofDays(days);
        TemporalAdjuster ta = p -> p.plus(period);
        return startDate.with(ta);
    }

    static TemporalAdjuster NEXT_SATURDAY
            = TemporalAdjusters.ofDateAdjuster(today -> {
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY) {
            return today;
        }

        if (dayOfWeek == DayOfWeek.SUNDAY) {
            return today.plusDays(6);
        }

        return today.plusDays(6 - dayOfWeek.getValue());
    });
}
