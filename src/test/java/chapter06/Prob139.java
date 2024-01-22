package chapter06;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.dom.DOMStructure;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class Prob139 {
    @Test
    void test() throws Exception {
        //given //when //then
        Path binaryFile = Paths.get("build/classes/modern/challenge/Main.class");

        int fileSize = (int) Files.readAttributes(binaryFile, BasicFileAttributes.class).size();

        final byte[] buffer = new byte[fileSize];
        try (InputStream is = new FileInputStream(binaryFile.toString())) {
            int i;
            while ((i = is.read(buffer)) != -1) {
                System.out.print("\nReading...");
            }
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(binaryFile.toFile()))) {
            int i;
            while ((i = bis.read(buffer)) != -1) {
                System.out.print("\nReading...");
            }
        }

        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(binaryFile))) {
            int i;
            while ((i = bis.read(buffer)) != -1) {
                System.out.print("\nReading...");
            }
        }

        try (ByteArrayInputStream bais = new ByteArrayInputStream(buffer)) {
            int i;
            while ((i = bais.read(buffer)) != -1) {
                System.out.print("\nReading...");
            }
        }

        Path dataFile = Paths.get("data.bin");

        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(Files.newInputStream(dataFile))
        )) {
            while (dis.available() > 0) {
                float nr = dis.readFloat();
                System.out.println("nr = " + nr);
            }
        }

        try (FileChannel fileChannel = FileChannel.open(binaryFile, EnumSet.of(StandardOpenOption.READ))) {
            MappedByteBuffer mbBuffer = fileChannel.map(
                    FileChannel.MapMode.READ_ONLY, 0, fileChannel.size()
            );

            System.out.printf("%nRead: %d bytes", mbBuffer.limit());
        }
    }

    @Test
    void test2() throws Exception {
        //given //when //then
        byte[] buffer = new byte[200];
        Path classFile = Paths.get("build/classes/modern/challenge/Main.class");

        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(classFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {
            bos.write(buffer);
        }

        Files.write(classFile, buffer, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        Path classFile2 = Paths.get("build/classes/modern/challenge/Main.class");
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                classFile2, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE)
        )) {
            MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, buffer.length);

            if (mbBuffer != null) {
                mbBuffer.put(buffer);
            }
        }
    }

    @Test
    void test3() throws Exception {
        //given //when //then
        Path floatFile = Paths.get("float.bin");

        try (DataOutputStream dis = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(floatFile))
        )) {
            dis.writeFloat(23.56f);
            dis.writeFloat(2.516f);
            dis.writeFloat(56.123f);
        }

    }
}
