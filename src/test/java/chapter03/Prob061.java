package chapter03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob061 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        LocalDateTime ldt = LocalDateTime.of(2020, 4, 1, 12, 31, 21, 675);

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        String localDateTimeAsString = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd hh:mm:ss a", Locale.US));
        System.out.println("localDateTimeAsString = " + localDateTimeAsString);
    }

}
