package chapter03;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob060 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        LocalDate onlyDate = LocalDate.now();
        System.out.println(onlyDate);

        LocalTime onlyTime = LocalTime.now();
        System.out.println(onlyTime);
    }

}
