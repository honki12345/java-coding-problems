package chapter06;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class CopyFileVisitor implements FileVisitor {
    private final Path copyFrom;
    private final Path copyTo;

    public CopyFileVisitor(Path copyFrom, Path copyTo) {
        this.copyFrom = copyFrom;
        this.copyTo = copyTo;
    }

    private static void copySubTree(Path copyFrom, Path copyTo) throws IOException {
        Files.copy(copyFrom, copyTo, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        Path newDir = copyTo.resolve(copyFrom.relativize((Path) dir));

        try {
            Files.copy((Path) dir, newDir, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            System.err.println("Unable to create " + newDir + " [" + e + " ]");

            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        try {
            copySubTree((Path) file, copyTo.resolve(
                    copyFrom.relativize((Path) file))
            );
        } catch (IOException e) {
//            System.err.println("Unable to create " + newDir + " [" + e + " ]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        if (exc instanceof FileSystemLoopException) {
            System.err.printf("Cycle was detected: %s%n", (Path)file);

        } else {
            System.err.printf("Error occured, unable to cpy: %s [%s]", file, exc);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        Path newDir = copyTo.resolve(
                copyFrom.relativize((Path) dir)
        );

        try {
            FileTime time = Files.getLastModifiedTime((Path) dir);
            Files.setLastModifiedTime(newDir, time);
        } catch (IOException e) {
            System.err.println("Unable to create " + newDir + " [" + e + " ]");
        }

        return FileVisitResult.CONTINUE;
    }
}
