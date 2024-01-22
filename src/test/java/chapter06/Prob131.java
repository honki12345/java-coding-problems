package chapter06;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob131 {
    @Test
    void test() throws Exception {
        //given //when //then
        Path base = Paths.get("/learning/packt");

//        /learning/packt/JBossTools3.pdf
        Path path = base.resolve("JBossTools3.pdf");
        System.out.println("path = " + path);

//        /learning/packt/MasteringJSF22.pdf
        Path path1 = base.resolve("MasteringJSF22.pdf");
        System.out.println("path1 = " + path1);

        String[] books = {
                "Book1.pdf",
                "Book2.pdf",
                "Book3.pdf"
        };

        for (String book : books) {
            Path nextBook = base.resolve(book);
            System.out.println("nextBook = " + nextBook);
        }

        Path path2 = base.resolveSibling("MasterJSF22.pdf");
        System.out.println("path2 = " + path2);

        Path path3 = base.getParent().resolveSibling("publisher")
                .resolve("MyBook.pdf");
        System.out.println("path3 = " + path3);
    }
}
