package chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob026 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        int x = 2;
        int y = 7;
        int z = x + y;
    }

    @DisplayName("")
    @Test
    void test2() {
        // given // when // then
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = x + y;

        Assertions.assertThrows(ArithmeticException.class, () -> Math.addExact(x, y));
        Assertions.assertDoesNotThrow(() -> Math.addExact(3, 6));

    }

}
