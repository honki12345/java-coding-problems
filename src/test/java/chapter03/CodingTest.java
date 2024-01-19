package chapter03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class CodingTest {
    @DisplayName("")
    @Test
    void test() {
        // given
        int year = 2022;
        Month month = Month.JANUARY;
        DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;

        // sol
        LocalDate localDate = LocalDate.of(year, month, 1);
        int answer;
        for (answer = 1; answer <= 5; answer++) {
            LocalDate adjustedDate = localDate.with(TemporalAdjusters.dayOfWeekInMonth(answer, dayOfWeek));
            if (adjustedDate.getMonth() != month) {
                break;
            }
        }
        System.out.println("answer = " + answer);
    }

    @DisplayName("")
    @Test
    void test2() {
        // given
        int year = 2022;
        Month month = Month.JANUARY;
        DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;

        // sol
        int daysOfMonth = YearMonth.of(year, month).lengthOfMonth();
        int answer = 0;
        for (int i = 1; i < daysOfMonth; i++) {
            if (LocalDate.of(year, month, i).getDayOfWeek() == dayOfWeek) {
                answer++;
            }
        }
        System.out.println("answer = " + answer);
    }

    @DisplayName("")
    @Test
    void test3() {
        // Given
        int year = 2022;
        Month month = Month.JANUARY;
        DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;

        // sol
        LocalDate localDate = LocalDate.of(year, month, 1);
        LocalDate firstDayOfWeek = localDate.with(TemporalAdjusters.firstInMonth(dayOfWeek));
        LocalDate lastDayOfWeek = localDate.with(TemporalAdjusters.lastInMonth(dayOfWeek));

        long count = Math.abs(ChronoUnit.DAYS.between(firstDayOfWeek, lastDayOfWeek)) / 7 + 1;
        System.out.println("count = " + count);
    }
}
