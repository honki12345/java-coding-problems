package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Prob090 {
    @DisplayName("")
    @Test
    void test() throws IOException {
        // Given // When // Then
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        numbers.filter(t -> t % 2 == 0).forEach(System.out::println);

        var numberStream = Stream.of(1, 2, 3, 4, 5);
        numberStream.filter(t -> t % 2 == 0).forEach(System.out::println);

        Stream<String> paths = Files.lines(Path.of(""));
        List<File> files = paths.map(File::new).toList();

        var pathStream = Files.lines(Path.of(""));
        var fileList = pathStream.map(File::new).toList();
    }

    @DisplayName("")
    @Test
    void test2() {
        // Given // When // Then
       ArrayList<Object> arrayList = new ArrayList<>();
       hi(arrayList);

    }

    public void hi(List<Object> parameter) {

        System.out.println("hi");
    }
}
