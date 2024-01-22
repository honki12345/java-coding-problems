package chapter06;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob132 {
    @Test
    void test() throws Exception {
        //given //when //then
        Path path1 = Paths.get("JBossTools3.pdf");
        Path path2 = Paths.get("JavaModernChallenge.pdf");

        Path path1ToPath2 = path1.relativize(path2);
        System.out.println("path1ToPath2 = " + path1ToPath2);

        Path path2ToPath1 = path2.relativize(path1);
        System.out.println("path2ToPath1 = " + path2ToPath1);

        Path path3 = Paths.get("/learning/packt/2003/JBossTools3.pdf");
        Path path4 = Paths.get("/learning/packt/2019");
        Path path3ToPath4 = path3.relativize(path4);
        System.out.println("path3ToPath4 = " + path3ToPath4);
        Path path4ToPath3 = path4.relativize(path3);
        System.out.println("path4ToPath3 = " + path4ToPath3);

    }
}
