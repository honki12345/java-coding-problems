package chapter06;

import org.junit.jupiter.api.Test;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Prob135 {
    @Test
    void test1() throws Exception {
        //given //when //then
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path path = Paths.get("/Users/kimgaby/me");
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        WatchKey key = watchService.take();
        for (WatchEvent<?> watchEvent : key.pollEvents()) {
            WatchEvent.Kind<?> kind = watchEvent.kind();
            WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
            Path filename = watchEventPath.context();
        }

        watchService.close();
    }
}
