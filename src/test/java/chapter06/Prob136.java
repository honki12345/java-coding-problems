package chapter06;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Prob136 {
    private static final String FILE_PATH = "/Users/kimgaby/me/test.txt";
    @Test
    void test() throws Exception {
        //given //when //then
        try (Stream<String> filesStream = Files.lines(Paths.get(FILE_PATH), StandardCharsets.UTF_8)) {
            filesStream.forEach(System.out::println);
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(FILE_PATH), StandardCharsets.UTF_8)) {
            bufferedReader.lines().forEach(System.out::println);

        }


    }
}
