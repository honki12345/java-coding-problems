package chapter01;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob024 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        String hello = Stream.of("hello")
            .map(s -> s + " world")
            .findFirst()
            .get();
        Assertions.assertEquals("hello world", hello);

        String gooooool = Stream.of("gooooool ")
            .map(String::toUpperCase)
            .map(s -> s.repeat(2))
            .map(s -> s.replaceAll("O", "OOOO"))
            .findFirst()
            .get();
        System.out.println(gooooool);
    }

}
