package chapter06;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob129 {
    @Test
    void tdd() throws Exception {
        //given //when //then
        Path path1 = Paths.get("/Users/kimgaby/Documents/board-plan.txt");
        Path path2 = Paths.get("/Users", "kimgaby/Documents/board-plan.txt");

        Path path = Path.of("/Users/kimgaby/Documents/board-plan.txt");

        Path path3 = FileSystems.getDefault()
                .getPath("/Users/kimgaby", "Documents/board-plan.txt");

        Path path4 = Paths.get(URI.create("file:///Users/kimgaby/Documents/board-plan.txt"));
    }

    private static final String FILE_SEPARATOR = File.separator;
//    private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();

    @Test
    void test2() throws Exception {
        //given //when //then

//        현재 작업 폴더 기준
        Path path = Paths.get("learning", "packt", "Javamodern.pdf");
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path rootDirectory : rootDirectories) {
            System.out.println("rootDirectory.toString() = " + rootDirectory.toString());
        }

    }
}
