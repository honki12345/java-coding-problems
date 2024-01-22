package chapter06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.stream.Stream;

public class Prob137 {
    @Test
    void test() throws Exception {
        //given //when //then
        Path startPath = Paths.get("/learning");

        try (Stream<Path> resultAsStream = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, basicFileAttributes) -> path.toString().endsWith(".properties"),
                FileVisitOption.FOLLOW_LINKS
        )) {
        }

        Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, basicFileAttributes) -> basicFileAttributes.isRegularFile() && path.getFileName().toString().startsWith("application")
        );

        Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, basicFileAttributes) -> basicFileAttributes.isDirectory() && basicFileAttributes.creationTime().toInstant()
                        .isAfter(LocalDate.of(2019, 3, 16).atStartOfDay().toInstant(ZoneOffset.UTC))

        );

        Stream<Path> resultAsStream = fetchFilesMatching(startPath, "glob:**/*.java");
    }

    public static Stream<Path> fetchFilesMatching(Path root, String syntaxPattern) throws IOException {
        final PathMatcher matcher = root.getFileSystem().getPathMatcher(syntaxPattern);

        return Files.find(root, Integer.MAX_VALUE,
                (path, basicFileAttributes) -> matcher.matches(path) && !basicFileAttributes.isDirectory());
    }

}
