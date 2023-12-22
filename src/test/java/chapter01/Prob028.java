package chapter01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob028 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        long result = Integer.toUnsignedLong(Integer.MIN_VALUE);
        System.out.println("result = " + result);

        int result1 = Short.toUnsignedInt(Short.MIN_VALUE);
        int result2 = Short.toUnsignedInt(Short.MAX_VALUE);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);


    }

}
