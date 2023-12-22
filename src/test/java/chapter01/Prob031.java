package chapter01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob031 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        double zero = 0;
        System.out.println(" ZERO / ZERO = " + (Double.NaN));

        System.out.println(3 / 0);

    }

}
