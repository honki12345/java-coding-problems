package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Prob095 {
    @DisplayName("")
    @Test
    void test() {
//        var incrementX = x -> x + 1;
//        var exceptionIAE = IllegalAccessException::new;

        Function<Integer, Integer> incrementX = x -> x + 1;
        Supplier<IllegalAccessException> exceptionIAE = IllegalAccessException::new;
        Square square = (var x) -> x * x;
    }
}
