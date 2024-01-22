package chapter06;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class Prob138 {
    private static final int MAP_SIZE = 5242880;

    @Test
    void test() throws Exception {
        //given //when //then
        Path chineseFile = Paths.get("chinese.txt");

        String content = Files.readString(chineseFile, StandardCharsets.UTF_16);

        try (FileChannel fileChannel = FileChannel.open(chineseFile, EnumSet.of(StandardOpenOption.READ))) {
            MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            if (mbBuffer != null) {
                String bufferContent = StandardCharsets.UTF_16.decode(mbBuffer).toString();
                System.out.println(bufferContent);
                mbBuffer.clear();
            }
        }
        try (FileChannel fileChannel = FileChannel.open(chineseFile, EnumSet.of(StandardOpenOption.READ))) {
            int position = 0;
            long length = fileChannel.size();

            while (position < length) {
                long remaining = length - position;
                int bytesToMap = (int) Math.min(MAP_SIZE, remaining);
                MappedByteBuffer mbBuffer = fileChannel.map(
                        FileChannel.MapMode.READ_ONLY, position, bytesToMap
                );

                position += bytesToMap;
            }
        }
    }

    @Test
    void test2() throws Exception {
        //given //when //then
        Path textFile = Paths.get("sample.txt");

        try (BufferedWriter bw = Files.newBufferedWriter(
                textFile,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE
        )) {
            bw.write("Lorem ipsum dolor sit amet, ...");
            bw.newLine();
            bw.write("sed do eiusmod");
        }

        List<String> linesToWrite = Arrays.asList("abc", "def", "ghi");
        Files.write(textFile, linesToWrite, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        String lineToWrite = "Lorem ipsum dolor sit amet, ...";
        Files.writeString(textFile, lineToWrite, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        CharBuffer cb = CharBuffer.wrap("\"Lorem ipsum dolor sit amet, ...\"");

        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(textFile, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE))) {
            MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, cb.length());

            if (mbBuffer != null) {
                mbBuffer.put(StandardCharsets.UTF_8.encode(cb));
            }
        }
    }

}
