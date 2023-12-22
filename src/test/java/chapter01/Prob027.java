package chapter01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob027 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
/*
        String nri = "100";
        int result = Integer.parseUnsignedInt(nri, 2);
        System.out.println(result);
*/

        int maxValue = Integer.MAX_VALUE;
        System.out.println("maxValue = " + maxValue);
        int maxValuePlus1 = Integer.parseUnsignedInt("2147483648");
        System.out.println("maxValuePlus1 = " + maxValuePlus1);

    }

}
