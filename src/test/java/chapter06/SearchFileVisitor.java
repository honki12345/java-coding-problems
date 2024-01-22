package chapter06;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchFileVisitor implements FileVisitor {
    private final Path fileNameToSearch;
    private boolean fileFound;

    public Path getFileNameToSearch() {
        return fileNameToSearch;
    }

    public boolean isFileFound() {
        return fileFound;
    }

    public SearchFileVisitor(Path fileNameToSearch) {
        this.fileNameToSearch = fileNameToSearch;
    }

    private boolean search(Path file) throws IOException {
        Path fileName = file.getFileName();

        if (fileNameToSearch.equals(fileName)) {
            System.out.println(String.format("Searched file was found: %s in %s", fileNameToSearch, file.toRealPath()));
            return true;
        }

        return false;
    }

    /**
     * fefw
     */
    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        fileFound = search((Path) file);

        if (!fileFound) {
            return FileVisitResult.CONTINUE;
        } else {
            return FileVisitResult.TERMINATE;
        }
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        return null;
    }


}
