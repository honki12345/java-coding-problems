package chapter02;

import java.time.temporal.ValueRange;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob044 {

    public class Function {

        private final int x;

        public Function(int x) {
            this.x = x;
        }

        public int xMinusY(int y) {
            return x - y;
        }

        public static int oneMinusY(int y) {
            return 1 - y;
        }
    }

    public class Function2 {

        private static final int X_UPPER_BOUND = 11;
        private static final int Y_UPPER_BOUND = 16;
        private final int x;

        public Function2(int x) {
            if (x < 0 || x >= X_UPPER_BOUND) {
                throw new IndexOutOfBoundsException("...");
            }

            this.x = x;
        }

        public int xMinusY(int y) {
            if (y < 0 || y >= x) {
                throw new IndexOutOfBoundsException("...");
            }
            return x - y;
        }

        public static int oneMinusY(int y) {
            if (y < 0 || y >= Y_UPPER_BOUND) {
                throw new IndexOutOfBoundsException("...");
            }

            return 1 - y;
        }

        public class Function3 {

            private static final int X_UPPER_BOUND = 11;
            private static final int Y_UPPER_BOUND = 16;
            private final int x;

            public Function3(int x) {
                this.x = Objects.checkIndex(x, X_UPPER_BOUND);
            }

            public int xMinusY(int y) {
                Objects.checkIndex(y, x);

                return x - y;
            }

            public static int oneMinusY(int y) {
                Objects.checkIndex(y, Y_UPPER_BOUND);

                return 1 - y;
            }
        }
    }

    @DisplayName("")
    @Test
    void test() {
        // given
        ValueRange valueRange = ValueRange.of(0, 4);

        // when // then
        Assertions.assertTrue(valueRange.isValidIntValue(0));
        Assertions.assertTrue(valueRange.isValidIntValue(4));
    }

}
