package chapter06;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob133 {
    @Test
    void test() throws Exception {
        //given //when //then
        Path path1 = Paths.get("/learning/packt/JavaModernChallenge.pdf");
        Path path2 = Paths.get("/LEARNING/PACKT/JavaModernChallenge.pdf");

        boolean sw = path1.startsWith("/learning/packt");
        System.out.println("sw = " + sw);
        boolean ew = path1.endsWith("JavaModernChallenge.pdf");
        System.out.println("ew = " + ew);

    }
}
