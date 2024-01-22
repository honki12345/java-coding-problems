package chapter06;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob130 {
    @Test
    void tdd() throws Exception {
        //given //when //then
        Path path = Paths.get("/learning/packt", "JavaModernChallenge.pdf");
        Path path1 = FileSystems.getDefault().getPath("/learning/packt", "JavaModernChallenge.pdf");

        String pathString = path.toString();
        System.out.println("pathString = " + pathString);
        System.out.println("path1 = " + path1);

        URI uri = path.toUri();
        System.out.println("uri = " + uri);

        URI uri1 = URI.create("https://www.learning.com/packt/JavaModernChallenge.pdf");
        Path fileName = Paths.get(uri.getPath()).getFileName();
        System.out.println("fileName = " + fileName);
        System.out.println("Paths.get(uri.getPath()) = " + Paths.get(uri.getPath()));

        Path absolutePath = path1.toAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
    }
}
