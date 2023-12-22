package chapter01;

import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob025 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        int i1 = -45;
        int i2 = -15;
        int min = Math.min(i1, i2);
        int max = Math.max(i1, i2);

        double d1 = 0.02343D;
        double d2 = 0.323233D;
        double min1 = Double.min(d1, d2);
        double max1 = Double.max(d1, d2);

        float f1 = 33.34F;
        float f2 = 33.213F;
        Float min3 = BinaryOperator.minBy(Float::compare).apply(f1, f2);
        Float max3 = BinaryOperator.maxBy(Float::compare).apply(f1, f2);
    }

}
