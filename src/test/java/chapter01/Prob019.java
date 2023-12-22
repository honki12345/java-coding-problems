package chapter01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob019 {

    private static final String LS = System.lineSeparator();

    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        String text = String.join(LS,
            "My high school,  ",
            "the Illinois Mathematics and Science Academy,",
            "showed me that anything is possible ",
            "and that you're never too young to think big.");

        String text2 = """
            My high school,
            the Illinois Mathematics and Science Academy
            show me that anything is possible""";

        System.out.println(text);
        System.out.println(text2);


    }

}
