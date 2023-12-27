package chapter02;

import java.util.Objects;

public class Prob045 {

    public class Function {

        private final int n;

        public Function(int n) {
            this.n = n;
        }

        public int yMinusX(int x, int y) {
            return y - x;
        }
    }

    public class Function2 {
        private static final int N_UPPER_BOUND = 101;
        private final int n;

        public Function2(int n) {
            if (n < 0 || n >= N_UPPER_BOUND) {
                throw new IndexOutOfBoundsException("...");
            }

            this.n = n;
        }

        public int yMinusX(int x, int y) {
            if (x < 0 || x > y || y >= n) {
                throw new IndexOutOfBoundsException("...");
            }
            return y - x;
        }
    }

    public class Function3 {
        private static final int N_UPPER_BOUND = 101;
        private final int n;

        public Function3(int n) {
            this.n = Objects.checkIndex(n, N_UPPER_BOUND);
        }

        public int yMinusX(int x, int y) {
            /*x, y로 제한한 범위인 [x, y]가 [0, n]의 부분 범위인지 검사*/
            Objects.checkFromToIndex(x, y, n);
            return y - x;
        }
    }
}
