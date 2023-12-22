package chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob030 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        int divisionSignedMinMax = Integer.MIN_VALUE / Integer.MAX_VALUE;
        System.out.println("divisionSignedMinMax = " + divisionSignedMinMax);

        int divisionSignedMaxMin = Integer.MAX_VALUE / Integer.MIN_VALUE;
        System.out.println("divisionSignedMaxMin = " + divisionSignedMaxMin);

        int moduloSignedMinMax = Integer.MIN_VALUE % Integer.MAX_VALUE;
        System.out.println("moduloSignedMinMax = " + moduloSignedMinMax);

        int moduloSignedMaxMin = Integer.MAX_VALUE % Integer.MIN_VALUE;
        System.out.println("moduloSignedMaxMin = " + moduloSignedMaxMin);

    }

    @DisplayName("")
    @Test
    void test2() {
        // given // when // then
        byte b1 = 100;
        byte b2 = (byte) (b1 << 1);
        Assertions.assertEquals(-56, b2);

    }

}
