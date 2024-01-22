package chapter06;

import org.junit.jupiter.api.Test;

import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.stream.Stream;

public class Prob134 {
    @Test
    void test() throws Exception {
        //given //when //then
        Path path = Paths.get("/Users/kimgaby/me");
        PathVisitor pathVisitor = new PathVisitor();
        Files.walkFileTree(path, pathVisitor);

    }

    @Test
    void test2() throws Exception {
        //given //when //then
        Path searchFile = Paths.get("JavaModernChallenge.pdf");

        SearchFileVisitor searchFileVisitor = new SearchFileVisitor(searchFile);

        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();

        for (Path root : roots) {
            if (!searchFileVisitor.isFileFound()) {
                Files.walkFileTree(root, opts, Integer.MAX_VALUE, searchFileVisitor);
            }
        }

    }

    @Test
    void test3() throws Exception {
        //given //when //then
        Path directory = Paths.get("/learning");
        DeleteFileVisitor deleteFileVisitor = new DeleteFileVisitor();
        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Files.walkFileTree(directory, deleteFileVisitor);
    }

    @Test
    void test4() throws Exception {
        //given //when //then
        Path copyFrom = Paths.get("D:/learning/packt");
        Path copyTo = Paths.get("D:/e-courses");

        CopyFileVisitor copyFileVisitor = new CopyFileVisitor(copyFrom, copyTo);

        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Files.walkFileTree(copyFrom, opts, Integer.MAX_VALUE, copyFileVisitor);

    }

    @Test
    void test5() throws Exception {
        //given //when //then
        Path directory = Paths.get("/learning");
        Stream<Path> streamOfPath = Files.walk(directory, FileVisitOption.FOLLOW_LINKS);
        streamOfPath.filter(e -> e.startsWith("/learning/book/cdi"))
                .forEach(System.out::println);

        long folderSize = Files.walk(directory)
                .filter(f -> f.toFile().isFile())
                .mapToLong(f -> f.toFile().length())
                .sum();
    }
}
