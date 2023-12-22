package chapter01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob036 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        float f = 0.1f;
        float next = Math.nextAfter(f, Float.NEGATIVE_INFINITY);
        System.out.println("next = " + next);

        float v = Math.nextAfter(f, -1.0);
        System.out.println("v = " + v);

    }

}
