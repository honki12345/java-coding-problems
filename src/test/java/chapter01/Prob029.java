package chapter01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob029 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        int resultSigned = Integer.compare(Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("resultSigned = " + resultSigned);

        int resultUnsigned = Integer.compareUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("resultUnsigned = " + resultUnsigned);

    }

}
