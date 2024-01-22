package chapter06;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Prob140 {
    @Test
    void test() throws Exception {
        //given //when //then

    }

    private static int countStringInString(String string, String tofind) {
        return string.split(Pattern.quote(tofind), -1).length - 1;
    }

    public static int countOccurrences(Path path, String text, Charset charset) throws IOException {
        int count = 0;

        try (BufferedReader br = Files.newBufferedReader(path, charset)) {
            String line;
            while ((line = br.readLine()) != null) {
                count += countStringInString(line, text);
            }
        }

        return count;
    }

    public static int countOccurrences2(Path path, String text, Charset charset) throws IOException{
        return Files.readAllLines(path, charset).parallelStream()
                .mapToInt(p -> countStringInString(p, text))
                .sum();
    }
    public static int countOccurrences3(Path path, String text, Charset charset) throws IOException {
        return Files.lines(path, charset).parallel()
                .mapToInt(p -> countStringInString(p, text))
                .sum();
    }
    public static long countOccurrences4(Path path, String text, Charset charset) throws IOException {
        long count;

        try (Scanner scanner = new Scanner(path, charset).useDelimiter(Pattern.quote(text))) {
            count = scanner.tokens().count() - 1;
        }

        return count;
    }

    private static final int MAP_SIZE = 5242880;

    public static int countOccurrences(Path path, String text) throws IOException {
        final byte[] texttofind = text.getBytes(StandardCharsets.UTF_8);
        int count = 0;

        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            int position = 0;
            long length = fileChannel.size();

            while (position < length) {
                long remaining = length - position;
                int bytestomap = (int) Math.min(MAP_SIZE, remaining);

                MappedByteBuffer mbBuffer = fileChannel.map(
                        FileChannel.MapMode.READ_ONLY, position, bytestomap
                );

                int limit = mbBuffer.limit();
                int lastSpace = -1;
                int firstChar = -1;

            }
        }
        return count;
    }

}
